package com.bblackbean.sboot.oldController;

import com.bblackbean.sboot.oldDto.MemberDTO;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")  // 공통된 url 경로
public class GetController {

    // http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String getHello() {
        return "Hello World";
    }

    // http://localhost:8080/api/v1/get-api/name
    @GetMapping(value="/name")
    public String getName() {
        return "bblackbean";
    }

    // http://localhost:8080/api/v1/get-api/variable1/{String 값}
    @GetMapping(value="/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    // http://localhost:8080/api/v1/get-api/variable2/{String 값}
    @GetMapping(value="/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    // http://localhost:8080/api/v1/get-api/request1?name=bblackbean&email=bbbbblackbean@gmail.com&organization=pnu
    @GetMapping(value="/request1")
    public String getRequestParm1(@RequestParam String name, @RequestParam String email, @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    // http://localhost:8080/api/v1/get-api/request2?key1=value1&key2=value2
    @GetMapping(value="/request2")
    public String getRequestParm2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        // param.forEach((key, value) -> sb.append(key).append(" : ").append(value).append("\n"));

        return sb.toString();
    }

    // http://localhost:8080/api/v1/get-api/request3?name=bblackbean&email=bbbbblackbean@gmail.com&organization=pnu
    @GetMapping(value="/request3")
    public String getRequestParm3(MemberDTO memberDTO) {
        // return memberDTO.getName() + " " + memberDTO.getEmail() + " " + memberDTO.GEToRGANIZATION();
        return memberDTO.toString();
    }
}
