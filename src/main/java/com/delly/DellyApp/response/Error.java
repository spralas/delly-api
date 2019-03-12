package com.delly.DellyApp.response;

import lombok.Data;

@Data
public class Error {

    private String errorType;
    private String exception;
    private String message;
    private String field;
    private ErrorCode errorCode;
}
