package com.delly.DellyApp.service;

import com.delly.DellyApp.model.AuthorizationResponse;
import com.delly.DellyApp.model.UserCredentials;
import com.delly.DellyApp.response.ResponseGeneric;

/**
 * Authorization service interface.
 */
public interface AuthorizationService {

    /**
     * Authentication.
     *
     * @param userCredentials User credentials.
     * @return Authorization response.
     */
    ResponseGeneric<AuthorizationResponse> authenticate(UserCredentials userCredentials);
}
