package com.liamfer.urlShortener.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    public String url;
    public String shortCode;
    @Column(columnDefinition = "integer default 0")
    public Integer accessCount;
    @CreatedDate
    public LocalDateTime createdAt;
    @LastModifiedDate
    public LocalDateTime updatedAt;

    public URLEntity(String url, String shortCode) {
        this.url = url;
        this.shortCode = shortCode;
    }
}
