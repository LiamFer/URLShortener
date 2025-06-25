package com.liamfer.urlShortener.DTO;

import jakarta.validation.constraints.NotBlank;

public record ShortURLBody(@NotBlank String url) {
}
