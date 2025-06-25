package com.liamfer.urlShortener.DTO;

import jakarta.validation.constraints.NotBlank;

public record newShortURL(@NotBlank String url) {
}
