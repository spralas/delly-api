package com.delly.DellyApp.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorResponse {

    private Header header;
    private ResponseType responseType;
    private List<Error> errors = new ArrayList<>();
    private List<Warning> warnings = new ArrayList<>();

    public void addErrorsItem(Error error) {
        errors.add(error);
    }
}
