package com.bblackbean.sboot.controller;

import com.bblackbean.sboot.common.Constants;
import com.bblackbean.sboot.common.exception.BblackbeanException;
import com.bblackbean.sboot.data.dto.ProductDto;
import com.bblackbean.sboot.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product-api")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;

    @Autowired  // 자동으로 연결해줌 (new로 객체화하지 않아도 서비스에 생성되어있는 객체를 자동으로 끌어옴)
    public ProductController(ProductService productService) { this.productService = productService; }

    // http://localhost:8080/api/v1/product-api/product/{productId}
    @GetMapping(value = "/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId) {

        long startTime = System.currentTimeMillis();
        LOGGER.info("[ProductController] perform {} of Bblackbean API.", "getProduct");

        ProductDto productDto =  productService.getProduct(productId);

        LOGGER.info("[ProductController] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms", productDto.getProductId(),
                productDto.getProductName(), productDto.getProductPrice(), productDto.getProductStock(), (System.currentTimeMillis() - startTime));

        return productDto;
    }

    // http://localhost:8080/api/v1/product-api/product
    @PostMapping("/product")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        String productId   = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice   = productDto.getProductPrice();
        int productStock   = productDto.getProductStock();
        // get으로 데이터 받아와서 각각의 값에 집어넣음

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }

    // http://localhost:8080/api/v1/product-api/product/{productId}
    @DeleteMapping("/product/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId) {return null;}

    @PostMapping(value = "/product/exception")
    public void exceptionTest() throws BblackbeanException {
        throw new BblackbeanException(Constants.ExceptionClass.PRODUCT, HttpStatus.FORBIDDEN, "접근이 금지되었습니다.");
    }
}
