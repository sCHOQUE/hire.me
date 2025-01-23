package com.yagod.url_shortener_app.repositories;

import com.yagod.url_shortener_app.domain.dto.UrlPopularResponseDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopUrlRepository extends JpaRepository<UrlPopularResponseDTO, String> {
    UrlPopularResponseDTO findTop10ByOrderByQttAccessDesc();
}
