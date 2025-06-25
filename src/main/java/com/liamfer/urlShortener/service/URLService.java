package com.liamfer.urlShortener.service;

import com.liamfer.urlShortener.DTO.shortURLResponse;
import com.liamfer.urlShortener.domain.URLEntity;
import com.liamfer.urlShortener.exceptions.ResourceNotFoundException;
import com.liamfer.urlShortener.repository.URLRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class URLService {
    private final URLRepository urlRepository;
    public URLService(URLRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public shortURLResponse shortUrl(String url){
        URLEntity newURL = urlRepository.save(new URLEntity(url,this.generateShortcode()));
        return this.newShortURLResponse(newURL);
    }

    public shortURLResponse getShortUrl(String shortCode){
        URLEntity url = this.findShortUrl(shortCode);
        url.increaseAccessCounter();
        urlRepository.save(url);
        return this.newShortURLResponse(url);
    }

    public URLEntity getShortUrlStatistics(String shortCode){
        return this.findShortUrl(shortCode);
    }

    public shortURLResponse updateShortUrl(String shortCode,String updateUrl){
        URLEntity url = this.findShortUrl(shortCode);
        url.setUrl(updateUrl);
        return newShortURLResponse(urlRepository.save(url));
    }

    private URLEntity findShortUrl(String shortCode){
        Optional<URLEntity> url = urlRepository.findByshortCode(shortCode);
        if(url.isPresent()) return url.get();
        throw new ResourceNotFoundException("URL não encontrada.");
    }

    public void deleteUrl(String shortCode){
        URLEntity url = this.findShortUrl(shortCode);
        urlRepository.deleteById(url.getId());
    }

    private String generateShortcode(){
        String shortCode = UUID.randomUUID().toString().replace("-","").substring(0,5);
        boolean exists = urlRepository.findByshortCode(shortCode).isPresent();
        while (exists) {
            shortCode = UUID.randomUUID().toString().replace("-","").substring(0,5);
            exists = urlRepository.findByshortCode(shortCode).isPresent();
        }
        return shortCode;
    }
    private shortURLResponse newShortURLResponse(URLEntity newURL){
        return new shortURLResponse(newURL.getId(),newURL.getUrl(),newURL.getShortCode(),newURL.getCreatedAt(),newURL.getUpdatedAt());
    }
}
