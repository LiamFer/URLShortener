package com.liamfer.urlShortener.controller;

import com.liamfer.urlShortener.DTO.ShortURLBody;
import com.liamfer.urlShortener.DTO.shortURLResponse;
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
    public ResponseEntity<shortURLResponse> shortenNewUrl(@RequestBody @Valid ShortURLBody newURL){
        return ResponseEntity.status(HttpStatus.CREATED).body(urlService.shortUrl(newURL.url()));
    }

    @GetMapping("/{shortCode}")
    public ResponseEntity<shortURLResponse> getShortenedUrl(@PathVariable("shortCode") @Valid String shortCode){
        return ResponseEntity.status(HttpStatus.OK).body(urlService.getShortUrl(shortCode));
    }

    @PutMapping("/{shortCode}")
    public ResponseEntity<shortURLResponse> updateShortenedUrl(@PathVariable("shortCode") @Valid String shortCode, @RequestBody @Valid ShortURLBody updateURL){
        return ResponseEntity.status(HttpStatus.OK).body(urlService.updateShortUrl(shortCode,updateURL.url()));
    }

    @DeleteMapping("/{shortCode}")
    public ResponseEntity<Void> deleteShortenedUrl(@PathVariable("shortCode") @Valid String shortCode){
        urlService.deleteUrl(shortCode);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
