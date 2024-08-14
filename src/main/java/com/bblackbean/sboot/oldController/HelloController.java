package com.bblackbean.sboot.oldController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    //@RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("hello")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("log-text")
    public void logTest(){
        LOGGER.trace("Trace Log");
        LOGGER.debug("Debug Log");
        LOGGER.info("Info Log");
        LOGGER.warn("Warn Log");
        LOGGER.error("Error Log");
    }

    @PostMapping("/exception")
    public void excepionTest() throws Exception {
        throw new Exception();
    }

    /*@ExceptionHandler(value = Exception.class)
    public ResponseEntity<Map<String, String>> ExceptionHandler(Exception e) {
        HttpHeaders responseHeaders = new HttpHeaders();
        //responseHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        LOGGER.info(e.getMessage());
        LOGGER.info("Controller 내 ExceptionHandler 호출");

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", "에러 발생");

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }*/

    // Jacoco 테스트용
    public String hello(String name) {
        switch (name){
            case "hi":
                return "nice to meet you";
            case "bblack":
                return "bean";
            default:
                return "hello method";
        }
    }

    public String callBean() {
        return "call Bean Class";
    }
}
