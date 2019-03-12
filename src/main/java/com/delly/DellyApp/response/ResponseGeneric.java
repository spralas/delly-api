package com.delly.DellyApp.response;

import lombok.Data;

@Data
public class ResponseGeneric<T> {

    private String status;
    private String message;
    private T data;

    public ResponseGeneric(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
