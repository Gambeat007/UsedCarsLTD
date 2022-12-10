package pl.gambeat007.ucl.user;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  Controller cLass for maintaining mapped user method(s),
 *  available only for company owner
 */

@RestController
@RequestMapping("/ucl")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    // retrieve all users with their roles
    @GetMapping("/users")
    @PreAuthorize("hasRole('OWNER')")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
