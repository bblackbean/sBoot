package com.bblackbean.sboot.controller;

import com.bblackbean.sboot.data.dto.ShortUrlResponseDto;
import com.bblackbean.sboot.service.ShortUrlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/short-url")
public class ShortUrlController {
    private final Logger LOGGER = LoggerFactory.getLogger(ShortUrlController.class);

    @Value("${bblackbean.short.url.id}")
    private String CLIENT_ID;

    @Value("${bblackbean.short.url.secret}")
    private String CLIENT_SECRET;

    ShortUrlService shortUrlService;

    @Autowired
    public ShortUrlController(ShortUrlService shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @PostMapping()
    public ShortUrlResponseDto generateShortUrl(String originalUrl) {
        LOGGER.info("[generateShortUrl] perform API. CLIENT_ID : {}, CLIENT_SECRET : {}", CLIENT_ID, CLIENT_SECRET);

        return shortUrlService.generateShortUrl(CLIENT_ID, CLIENT_SECRET, originalUrl);
    }

    @GetMapping()
    public ShortUrlResponseDto getShortUrl(String originalUrl) {
        long startTime = System.currentTimeMillis();
        ShortUrlResponseDto shortUrlResponseDto = shortUrlService.getShortUrl(CLIENT_ID, CLIENT_SECRET, originalUrl);
        long endTime = System.currentTimeMillis();

        LOGGER.info("[getShortUrl] response Time : {}ms", (endTime - startTime));

        return shortUrlResponseDto;
    }

    @PutMapping("/")
    public ShortUrlResponseDto updateShortUrl(String originalUrl) {
        return null;
    }

    @DeleteMapping("/")
    public ResponseEntity<String> deleteShortUrl(String url) {
        try {
            shortUrlService.deleteShortUrl(url);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}
