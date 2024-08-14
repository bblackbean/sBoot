package com.bblackbean.sboot.oldService;

import com.bblackbean.sboot.oldDto.MemberDTO;
import org.springframework.http.ResponseEntity;

public interface RestTemplateService {
    public String getBblackbean();

    public String getName();

    public String getName2();

    public ResponseEntity<MemberDTO> postDto();

    public ResponseEntity<MemberDTO> addHeader();
}
