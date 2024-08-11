package com.bblackbean.sboot.service.impl;

import com.bblackbean.sboot.dto.MemberDTO;
import com.bblackbean.sboot.service.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    private final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);

    @Override
    public String getBblackbean() {
        // 어떤 경로로 요청을 할건지...
        URI uri =
                UriComponentsBuilder.fromUriString("http://localhost:8081") // UriComponentsBuilder를 사용해서 uri를 만들 것
                        .path("/api/server/bblack-bean")    // 뒤에 붙는 경로
                        .encode()   // 기본적인 인코딩은 utf-8
                        .build()    // 전체적인 값들을 넣는 작업을 마침
                        .toUri();   // uri 값으로 변경

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);   //  String.class => 서버에서 응답하는 데이터를 String으로 받아옴

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public String getName() {

        URI uri =
                UriComponentsBuilder.fromUriString("http://localhost:8081")
                        .path("/api/server/name")
                        .queryParam("name", "bblackbean")
                        .encode()
                        .build()
                        .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public String getName2() {
        URI uri =
                UriComponentsBuilder.fromUriString("http://localhost:8081")
                        .path("/api/server/path-variable/{name}")
                        .encode()
                        .build()
                        .expand("bblackbean") // 복수의 값을 넣어야할 경우 , 를 추가하여 구분
                        .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity.getBody();
    }

    @Override
    public ResponseEntity<MemberDTO> postDto() {
        URI uri =
                UriComponentsBuilder.fromUriString("http://localhost:8081")
                        .path("/api/server/member")
                        .queryParam("name", "bean")
                        .queryParam("email", "jjj@jjj.com")
                        .queryParam("organization", "bblackbean")
                        .encode()
                        .build()
                        .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("bean!!");
        memberDTO.setEmail("aaa@aaa.com");
        memberDTO.setOrganization("bblackbean!!");

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity =
                restTemplate.postForEntity(uri, memberDTO, MemberDTO.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity;
    }

    @Override
    public ResponseEntity<MemberDTO> addHeader() {
        URI uri =
                UriComponentsBuilder.fromUriString("http://localhost:8081")
                        .path("/api/server/add-header")
                        .encode()
                        .build()
                        .toUri();

        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setName("bean");
        memberDTO.setEmail("jjj@jjj.com");
        memberDTO.setOrganization("bblackbean");

        RequestEntity<MemberDTO> requestEntity =
                RequestEntity.post(uri).header("bblackbean-header", "bblackbean").body(memberDTO);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<MemberDTO> responseEntity =
                restTemplate.exchange(requestEntity, MemberDTO.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());

        return responseEntity;
    }
}
