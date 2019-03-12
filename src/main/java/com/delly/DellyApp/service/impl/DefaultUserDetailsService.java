package com.delly.DellyApp.service.impl;

import com.delly.DellyApp.enums.Authority;
import com.delly.DellyApp.model.AuthenticatedUserDetails;
import com.delly.DellyApp.model.User;
import com.delly.DellyApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Default implementation for the {@link UserDetailsService}.
 *
 * @author spralas
 */
@Service
public class DefaultUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userService.findUserByUserNameOrEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }

        return new AuthenticatedUserDetails.Builder()
                .withUsername(user.getUsername())
                .withPassword(user.getPassword())
                .withAuthorities(mapToGrantedAuthorities(user.getAuthorities()))
                .withActive(user.isActive())
                .build();
    }

    private Set<GrantedAuthority> mapToGrantedAuthorities(Set<Authority> authorities) {
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.toString()))
                .collect(Collectors.toSet());
    }
}