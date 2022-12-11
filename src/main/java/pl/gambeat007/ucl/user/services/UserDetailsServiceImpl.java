package pl.gambeat007.ucl.user.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.gambeat007.ucl.user.User;
import pl.gambeat007.ucl.user.UserRepository;

/**
 * Service class implements UserDetailsService interface and override its method,
 * this is needed to get UserDetails object
 */

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // getting custom User with userRepository
        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User: " + username + " not found."));
        // build UserDetails
        return UserDetailsImpl.build(user);
    }
}
