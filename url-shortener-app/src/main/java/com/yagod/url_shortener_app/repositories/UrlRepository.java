package com.yagod.url_shortener_app.repositories;

import com.yagod.url_shortener_app.entities.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<UrlEntity, String> {

}
