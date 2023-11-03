package com.bblackbean.sboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean   // Bean 객체로 만들겠다
    public Docket api() {   // Docket 이라는 객체를 반환하는 메서드를 생성
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())     // api의 정보들을 담음
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.bblackbean.sboot"))  // RestController 스캔을 해야하는데, 어디를 범위로 스캔할 것인가?
            .paths(PathSelectors.any())
            .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("bblackbean Sboot Open API Test with Swagger")
            .description("설명 부분")
            .version("1.0.0")
            .build();
    }
}
