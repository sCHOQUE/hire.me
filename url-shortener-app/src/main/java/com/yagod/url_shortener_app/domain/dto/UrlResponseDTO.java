package com.yagod.url_shortener_app.domain.dto;

import com.yagod.url_shortener_app.domain.StatisticsResponse;

public record UrlResponseDTO(String url, String alias, StatisticsResponse statistics) {
}
