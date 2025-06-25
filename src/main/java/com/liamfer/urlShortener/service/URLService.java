package com.liamfer.urlShortener.service;

import com.liamfer.urlShortener.DTO.shortURLResponse;
import com.liamfer.urlShortener.domain.URLEntity;
import com.liamfer.urlShortener.repository.URLRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class URLService {
    private final URLRepository urlRepository;
    public URLService(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public shortURLResponse shortUrl(String url){
        URLEntity newURL = urlRepository.save(new URLEntity(url,this.generateShortcode()));
        return new shortURLResponse(newURL.getId(),newURL.getUrl(),newURL.getShortCode(),newURL.getCreatedAt(),newURL.getUpdatedAt());
    }

    private String generateShortcode(){
        String shortCode = UUID.randomUUID().toString().replace("-","").substring(0,5);
        boolean exists = urlRepository.findByshortCode(shortCode) != null;
        while (exists) {
            shortCode = UUID.randomUUID().toString().replace("-","").substring(0,5);
            exists = urlRepository.findByshortCode(shortCode) != null;
        }
        return shortCode;
    }

}
