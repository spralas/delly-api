package com.delly.DellyApp.service.impl;

import com.delly.DellyApp.enums.Authority;
import com.delly.DellyApp.model.AuthorizationResponse;
import com.delly.DellyApp.model.User;
import com.delly.DellyApp.model.UserCredentials;
import com.delly.DellyApp.response.ResponseGeneric;
import com.delly.DellyApp.response.ResponseMessage;
import com.delly.DellyApp.response.ResponseStatus;
import com.delly.DellyApp.service.AuthenticationTokenService;
import com.delly.DellyApp.service.AuthorizationService;
import com.delly.DellyApp.service.UserService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    private AuthenticationManager authenticationManager;

    private AuthenticationTokenService authenticationTokenService;

    private UserService userService;

    public AuthorizationServiceImpl(AuthenticationManager authenticationManager, AuthenticationTokenService authenticationTokenService,
                                    UserService userService) {
        this.authenticationManager = authenticationManager;
        this.authenticationTokenService = authenticationTokenService;
        this.userService = userService;
    }

    @Override
    public ResponseGeneric<AuthorizationResponse> authenticate(UserCredentials userCredentials) {
        Authentication authenticationRequest =
                new UsernamePasswordAuthenticationToken(userCredentials.getUsername(), userCredentials.getPassword());
        Authentication authenticationResult = authenticationManager.authenticate(authenticationRequest);
        SecurityContextHolder.getContext().setAuthentication(authenticationResult);

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Set<Authority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .map(grantedAuthority -> Authority.valueOf(grantedAuthority.toString()))
                .collect(Collectors.toSet());

        String token = authenticationTokenService.issueToken(username, authorities);

        User user = userService.findUserByUserNameOrEmail(userCredentials.getUsername());

        return new ResponseGeneric<>(ResponseStatus.OK.getDescription(), ResponseMessage.SUCCESS.getDescription(), new AuthorizationResponse(user.getUserId(), token, user.getEmail()));
    }
}
