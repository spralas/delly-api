package com.delly.DellyApp.jwt;

import com.delly.DellyApp.model.AuthenticationTokenDetails;
import com.delly.DellyApp.service.AuthenticationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 * Authentication provider for JWT token-based authentication.
 */
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    @Qualifier("defaultUserDetailsService")
    private UserDetailsService userDetailsService;

    @Autowired
    @Qualifier("defaultAuthenticationTokenService")
    private AuthenticationTokenService authenticationTokenService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String authenticationToken = (String) authentication.getCredentials();
        AuthenticationTokenDetails authenticationTokenDetails = authenticationTokenService.parseToken(authenticationToken);
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationTokenDetails.getUsername());

        return new JwtAuthenticationToken(userDetails, authenticationTokenDetails, userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }
}