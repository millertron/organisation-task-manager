package com.millertronics.otm.authorizationservice.service;

import com.millertronics.otm.authorizationservice.model.UserDetailsImpl;
import com.millertronics.otm.authorizationservice.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserDetails userDetails = userRepository.findByUsername(username)
                .map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found for username: " + username));
        new AccountStatusUserDetailsChecker().check(userDetails);
        return userDetails;
    }
}
