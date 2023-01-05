package com.fossil.assetmanagementsystem.exceptions;

public class InvalidLoginException extends RuntimeException {
    public InvalidLoginException(String exception, String invalid_username_or_password) {
        super(exception);
    }
}
