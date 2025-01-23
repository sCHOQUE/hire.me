package com.yagod.url_shortener_app.domain.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Builder;

@Entity
@Builder
public class UrlPopularRequestDTO {

    @Id
    private String id;
    @Column(name = "int_qtt_access_ust")
    private int qttAccess;
}
