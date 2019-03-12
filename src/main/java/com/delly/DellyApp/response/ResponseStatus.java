package com.delly.DellyApp.response;

import org.springframework.http.HttpStatus;

public enum ResponseStatus {

    OK(HttpStatus.OK.toString()),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.toString());

    private final String description;

    private ResponseStatus(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
