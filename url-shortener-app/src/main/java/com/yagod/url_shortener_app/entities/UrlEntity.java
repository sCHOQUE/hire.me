package com.yagod.url_shortener_app.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "tb_ust_url_shorted")
@NoArgsConstructor
@Builder
public class UrlEntity {
    @Id
    private String id;

    @Column(name = "str_url_ust")
    private String url;
    @Column(name = "int_qtt_access_ust")
    private int qttAccess = 0;

    public UrlEntity(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public UrlEntity(String id, String url, int qttAccess) {
        this.id = id;
        this.url = url;
        this.qttAccess = qttAccess;
    }
}
