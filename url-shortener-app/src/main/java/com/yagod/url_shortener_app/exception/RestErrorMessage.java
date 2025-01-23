package com.yagod.url_shortener_app.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
@AllArgsConstructor
@Getter
@Setter
public class RestErrorMessage {
    private String alias;
    private String errCode;
    private String description;
}
