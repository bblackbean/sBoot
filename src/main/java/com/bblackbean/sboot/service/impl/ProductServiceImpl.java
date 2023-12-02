package com.bblackbean.sboot.service.impl;

import com.bblackbean.sboot.data.dto.ProductDto;
import com.bblackbean.sboot.data.entity.ProductEntity;
import com.bblackbean.sboot.data.handler.ProductDataHandler;
import com.bblackbean.sboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service    // 여기가 본체라서 서비스 어노테이션 붙여줌
public class ProductServiceImpl implements ProductService {

    ProductDataHandler productDataHandler;

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler){
        this.productDataHandler = productDataHandler;
    }

    @Override
    public ProductDto saveProduct(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity = productDataHandler.saveProductEntity(productId, productName, productPrice, productStock);

        ProductDto productDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName(),
                                               productEntity.getProductPrice(), productEntity.getProductStock());

        return productDto;
    }

    @Override
    public ProductDto getProduct(String productId) {
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);

        ProductDto productDto = new ProductDto(productEntity.getProductId(), productEntity.getProductName(),
                                               productEntity.getProductPrice(), productEntity.getProductStock());

        return productDto;
    }
}
