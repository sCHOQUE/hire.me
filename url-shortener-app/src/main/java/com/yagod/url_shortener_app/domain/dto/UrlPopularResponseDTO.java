package com.yagod.url_shortener_app.domain.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UrlPopularResponseDTO {
    @Id
    private String id;
    @Column(name = "int_qtt_access_ust")
    private int qttAccess;
    private String alias;
}
