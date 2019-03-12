package com.delly.DellyApp.response;

public enum ResponseMessage {

    SUCCESS("Success"),
    ERROR("Error");

    private String description;

    private ResponseMessage(final String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
