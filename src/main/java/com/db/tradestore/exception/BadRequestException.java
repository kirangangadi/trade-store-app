package com.db.tradestore.exception;

import lombok.Getter;

@Getter
public class BadRequestException extends RuntimeException {

    private String statusCode;

    public BadRequestException(String message, String statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
