package com.liamfer.urlShortener.controller;

import com.liamfer.urlShortener.DTO.newShortURL;
import com.liamfer.urlShortener.DTO.shortURLResponse;
import com.liamfer.urlShortener.domain.URLEntity;
import com.liamfer.urlShortener.service.URLService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shorten")
public class URLController {
    private final URLService urlService;
    public URLController(URLService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public ResponseEntity<shortURLResponse> shortenNewUrl(@RequestBody @Valid newShortURL newURL){
        return ResponseEntity.status(HttpStatus.CREATED).body(urlService.shortUrl(newURL.url()));
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<shortURLResponse> getShortenedUrl(@PathVariable("shortCode") @Valid String shortCode){
        return ResponseEntity.status(HttpStatus.OK).body(urlService.getShortUrl(shortCode));
    }
}
