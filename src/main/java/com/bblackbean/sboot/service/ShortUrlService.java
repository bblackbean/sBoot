package com.bblackbean.sboot.service;

import com.bblackbean.sboot.data.dto.ShortUrlResponseDto;

public interface ShortUrlService {
    ShortUrlResponseDto getShortUrl(String clientId, String clientSecret, String originalUrl);

    ShortUrlResponseDto generateShortUrl(String clientId, String clientSecret, String originalUrl);

    ShortUrlResponseDto updateShortUrl(String clientId, String clientSecret, String originalUrl);

    void deleteShortUrl(String url);

}
