package com.delly.DellyApp.response;

public enum ErrorCode {

    OK("OK");

    private String value;

    ErrorCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
