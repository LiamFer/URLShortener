package com.liamfer.urlShortener.DTO;

import java.time.LocalDateTime;

public record shortURLResponse(Long id, String url,
                               String shortCode, LocalDateTime createdAt,
                               LocalDateTime updatedAt) {
}
