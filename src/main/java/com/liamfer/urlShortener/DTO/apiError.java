package com.liamfer.urlShortener.DTO;


public record apiError<T>(int code,T message) {
}
