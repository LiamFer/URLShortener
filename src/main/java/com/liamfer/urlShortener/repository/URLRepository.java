package com.liamfer.urlShortener.repository;

import com.liamfer.urlShortener.domain.URLEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface URLRepository extends JpaRepository<URLEntity,Long>{
    Optional<URLEntity> findByshortCode(String shortCode);
}
