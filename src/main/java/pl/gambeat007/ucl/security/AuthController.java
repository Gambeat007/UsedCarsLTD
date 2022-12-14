package pl.gambeat007.ucl.security;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.gambeat007.ucl.role.UCLRole;
import pl.gambeat007.ucl.payload.request.LoginRequest;
import pl.gambeat007.ucl.payload.request.SignupRequest;
import pl.gambeat007.ucl.payload.response.MessageResponse;
import pl.gambeat007.ucl.payload.response.UserInfoResponse;
import pl.gambeat007.ucl.security.jwt.JwtUtils;
import pl.gambeat007.ucl.role.Role;
import pl.gambeat007.ucl.role.RoleRepository;
import pl.gambeat007.ucl.user.services.UserDetailsImpl;
import pl.gambeat007.ucl.user.User;
import pl.gambeat007.ucl.user.UserRepository;

/**
 *  Controller cLass for maintaining mapped user method(s),
 *  authentication, log -in/out process
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/ucl/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        // Username and password authentication
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        // update context with authentication object
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // get user details from authentication object
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        // generate jwt
        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());
        // response with jwt and user details
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponse(userDetails.getId(), userDetails.getUsername(), userDetails.getEmail(), roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        // existing username & email check
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Username already taken!"));
        }
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Email already in use!"));
        }
        // create new user
        User user = new User(signUpRequest.getUsername(), signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
        Set<String> setOfRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();
        // if role is not specified - "give" public
        if (setOfRoles == null) {
            Role noRestrictions = roleRepository.findByName(UCLRole.ROLE_PUBLIC).orElseThrow(() ->
                    new RuntimeException("Role not found."));
            roles.add(noRestrictions);
        } else {
            setOfRoles.forEach(role -> {
                switch (role) {
                    case "owner" -> {
                        Role owner = roleRepository.findByName(UCLRole.ROLE_OWNER).orElseThrow(() ->
                                new RuntimeException("Role not found."));
                        roles.add(owner);
                    }
                    case "customer" -> {
                        Role customer = roleRepository.findByName(UCLRole.ROLE_CUSTOMER).orElseThrow(() ->
                                new RuntimeException("Role not found."));
                        roles.add(customer);
                    }
                    default -> {
                        Role noRestrictions = roleRepository.findByName(UCLRole.ROLE_PUBLIC).orElseThrow(() ->
                                new RuntimeException("Role not found."));
                        roles.add(noRestrictions);
                    }
                }
            });
        }
        user.setRoles(roles);
        // save user to database
        userRepository.save(user);
        return ResponseEntity.ok(new MessageResponse("Registration successful!"));
    }

    // "clear cookie" method
    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.cleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).body(new MessageResponse("Signed out."));
    }
}