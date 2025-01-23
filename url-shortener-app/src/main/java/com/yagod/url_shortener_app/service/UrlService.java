package com.yagod.url_shortener_app.service;

import com.yagod.url_shortener_app.domain.dto.UrlRequestDTO;
import com.yagod.url_shortener_app.domain.dto.UrlResponseDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;

public interface UrlService {

    UrlResponseDTO shortenUrl(UrlRequestDTO data, HttpServletRequest request);

    HttpHeaders redirect(String id);

    boolean verifyAlias(String alias);
}
