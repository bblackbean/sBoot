package com.bblackbean.sboot.data.dao.impl;

import com.bblackbean.sboot.data.dao.ProductDAO;
import com.bblackbean.sboot.data.entity.ProductEntity;
import com.bblackbean.sboot.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOimpl implements ProductDAO {

    ProductRepository productRepository;

    @Autowired
    public ProductDAOimpl(ProductRepository productRepository) {    // 미리 띄워져있는 Repository를 끌어와서 의존성 주입
        this.productRepository = productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);  // save : jpa repository 에서 기본적으로 제공
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId) {
        ProductEntity productEntity = productRepository.getById(productId);     // getById : jpa repository 에서 기본적으로 제공
        return productEntity;
    }
}
