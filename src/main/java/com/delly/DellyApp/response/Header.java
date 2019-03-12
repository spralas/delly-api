package com.delly.DellyApp.response;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Header {

    private Timestamp timestamp;

    private Integer status;

    private String url;
}
