package com.delly.DellyApp.service;

import com.delly.DellyApp.model.AuthorizationResponse;
import com.delly.DellyApp.model.UserCredentials;
import com.delly.DellyApp.response.ResponseGeneric;

public interface AuthorizationService {

    ResponseGeneric<AuthorizationResponse> authenticate(UserCredentials userCredentials);
}
