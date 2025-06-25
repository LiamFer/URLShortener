package com.liamfer.urlShortener.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "short_url")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class URLEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    public String url;
    public String shortCode;
    @CreatedDate
    public LocalDateTime createdAt;
    @LastModifiedDate
    public LocalDateTime updatedAt;
}
