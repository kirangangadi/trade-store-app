package com.db.tradestore.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    private String statusCode;

    public NotFoundException(String message, String statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
