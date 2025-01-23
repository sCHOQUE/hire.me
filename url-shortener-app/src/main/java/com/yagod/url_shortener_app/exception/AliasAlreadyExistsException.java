package com.yagod.url_shortener_app.exception;

public class AliasAlreadyExistsException extends RuntimeException {
    public AliasAlreadyExistsException() { super("ALIAS ALREADY EXISTS"); }

    public AliasAlreadyExistsException(String message) { super(message); }
}
