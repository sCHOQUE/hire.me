package com.yagod.url_shortener_app.controller;

import com.yagod.url_shortener_app.domain.dto.UrlPopularRequestDTO;
import com.yagod.url_shortener_app.domain.dto.UrlPopularResponseDTO;
import com.yagod.url_shortener_app.domain.dto.UrlRequestDTO;
import com.yagod.url_shortener_app.domain.dto.UrlResponseDTO;
import com.yagod.url_shortener_app.repositories.TopUrlRepository;
import com.yagod.url_shortener_app.repositories.UrlRepository;
import com.yagod.url_shortener_app.utils.CalculateTimeProc;
import com.yagod.url_shortener_app.service.UrlService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/shortener")
public class ShortenerController {
    @Autowired
    private UrlService urlService;

    @Autowired
    TopUrlRepository topUrlRepository;

    @Autowired CalculateTimeProc calculateTimeProc;

    @PutMapping(value = "/create")
    public ResponseEntity<UrlResponseDTO> create(@RequestBody UrlRequestDTO data, HttpServletRequest request) {
        return ResponseEntity.ok(urlService.shortenUrl(data, request));
    }

    @GetMapping("/{alias}")
    public ResponseEntity<Void> redirect(@PathVariable("alias") String alias) {
        HttpHeaders headers = urlService.redirect(alias);
        return ResponseEntity.status(HttpStatus.FOUND).headers(headers).build();
    }

    @GetMapping("/checkPopular")
    public UrlPopularResponseDTO checkPopular(){
        UrlPopularResponseDTO urlPopularResponseDTO = topUrlRepository.findTop10ByOrderByQttAccessDesc();
        log.info("RETURN FROM QUERY" + urlPopularResponseDTO);
        return urlPopularResponseDTO;
    }

}
