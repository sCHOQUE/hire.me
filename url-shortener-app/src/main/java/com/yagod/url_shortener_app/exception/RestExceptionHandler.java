package com.yagod.url_shortener_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler()
    private ResponseEntity<RestErrorMessage> aliasAlreadyExists(AliasAlreadyExistsException exception){
        final String errcode001 = "001";
        final String descriptionAlreadyExists = "CUSTOM ALIAS ALREADY EXISTS";

        RestErrorMessage threatResponse = new RestErrorMessage(exception.getMessage(), errcode001, descriptionAlreadyExists);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(threatResponse);
    }
}
