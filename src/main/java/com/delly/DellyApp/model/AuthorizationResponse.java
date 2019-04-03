package com.delly.DellyApp.model;

import lombok.Data;

/**
 * Authorization response.
 */
@Data
public class AuthorizationResponse {

    private Long id;

    private String token;

    private String email;

    public AuthorizationResponse(Long id, String token, String email) {
        this.id = id;
        this.token = token;
        this.email = email;
    }
}
