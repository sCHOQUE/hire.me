package com.yagod.url_shortener_app.repositories;

import com.yagod.url_shortener_app.entities.UrlEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UrlRepository extends JpaRepository<UrlEntity, String> {

}
