package com.delly.DellyApp.controllers;

import com.delly.DellyApp.model.AuthenticationToken;
import com.delly.DellyApp.model.AuthenticationTokenDetails;
import com.delly.DellyApp.model.AuthorizationResponse;
import com.delly.DellyApp.model.UserCredentials;
import com.delly.DellyApp.response.ResponseGeneric;
import com.delly.DellyApp.service.AuthenticationTokenService;
import com.delly.DellyApp.service.AuthorizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * JAX-RS resource class for authentication. Username and password are exchanged for an authentication token.
 *
 */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private AuthorizationService authorizationService;

    private AuthenticationTokenService authenticationTokenService;

    public AuthenticationController(AuthorizationService authorizationService, AuthenticationTokenService authenticationTokenService) {
        this.authorizationService = authorizationService;
        this.authenticationTokenService = authenticationTokenService;
    }

    /**
     * Validate user credentials and issue a token for the user.
     *
     * @param credentials
     * @return
     */
    @PostMapping
    public ResponseEntity<ResponseGeneric<AuthorizationResponse>> authenticate(@RequestBody UserCredentials credentials) {

        return ResponseEntity.ok(authorizationService.authenticate(credentials));
    }

    /**
     * Refresh the authentication token for the current user.
     *
     * @return
     */
    @PostMapping("/refresh")
    public ResponseEntity refresh() {

        AuthenticationTokenDetails tokenDetails = (AuthenticationTokenDetails)
                SecurityContextHolder.getContext().getAuthentication().getDetails();

        String token = authenticationTokenService.refreshToken(tokenDetails);
        AuthenticationToken authenticationToken = new AuthenticationToken();
        authenticationToken.setToken(token);

        return ResponseEntity.ok(authenticationToken);
    }

}
