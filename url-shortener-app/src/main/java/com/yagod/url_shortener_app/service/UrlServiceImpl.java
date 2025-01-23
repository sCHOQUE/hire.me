package com.yagod.url_shortener_app.service;

import com.yagod.url_shortener_app.domain.StatisticsResponse;
import com.yagod.url_shortener_app.domain.dto.UrlPopularResponseDTO;
import com.yagod.url_shortener_app.domain.dto.UrlRequestDTO;
import com.yagod.url_shortener_app.domain.dto.UrlResponseDTO;
import com.yagod.url_shortener_app.entities.UrlEntity;
import com.yagod.url_shortener_app.exception.AliasAlreadyExistsException;
import com.yagod.url_shortener_app.repositories.UrlRepository;
import com.yagod.url_shortener_app.utils.CalculateTimeProc;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    @Autowired
    CalculateTimeProc calculateTimeProc;

    @Override
    public UrlResponseDTO shortenUrl(UrlRequestDTO data, HttpServletRequest request) {
        calculateTimeProc.StartTime();
        String id;

        if(data.alias() != null) {
            id = data.alias();
        } else {
            do {
                id = RandomStringUtils.randomAlphanumeric(6, 10);
                log.info("ALIAS GERADO:" + id);
            } while (urlRepository.existsById(id));
        }

        if(verifyAlias(id)){
            log.info("ENTROU NO IF");
            throw new AliasAlreadyExistsException(id);
        }

        urlRepository.save(new UrlEntity(id, data.url()));

        String redirectUrl = request.getRequestURL().toString().replace("create", id);

        StatisticsResponse statisticsResponse = new StatisticsResponse();
        statisticsResponse.setTime_taken(calculateTimeProc.Endtime());

        return new UrlResponseDTO(data.url(), redirectUrl, statisticsResponse);
    }

    @Override
    public HttpHeaders redirect(String id) {
        UrlEntity url = urlRepository.findById(id).orElseThrow();

        urlRepository.save(new UrlEntity(url.getId(), url.getUrl(), url.getQttAccess()+1));

        HttpHeaders headers = new HttpHeaders();

        headers.setLocation(URI.create(url.getUrl()));
        return headers;
    }

    @Override
    public boolean verifyAlias(String alias) {
        Optional<UrlEntity> repeatedAlias = urlRepository.findById(alias);
        log.info("REPEATEDALIAS:" + repeatedAlias);
        if(repeatedAlias.isPresent()){
            log.info("ENTROU NO TRUE");
            return true;
        }
        log.info("ENTROU NO FALSE");
        return false;
    }
}
