package com.fossil.assetmanagementsystem.exceptions;

public class InvalidLoginException extends RuntimeException {
    public InvalidLoginException(String exception) {
        super(exception);
    }
}
