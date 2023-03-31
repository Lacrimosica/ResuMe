package com.resume.resumetool.security.service;

import com.resume.resumetool.data.entity.Role;
import com.resume.resumetool.data.entity.User;
import com.resume.resumetool.data.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

@RequiredArgsConstructor
public class InMemoryUserDetailsService implements UserDetailsService {

    private final List<UserDetails> users;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream().filter(
                u -> u.getUsername().equals(username)
        )
                .findFirst()
                .orElseThrow(
                        () -> new UsernameNotFoundException("User not found")
        );
    }
}
