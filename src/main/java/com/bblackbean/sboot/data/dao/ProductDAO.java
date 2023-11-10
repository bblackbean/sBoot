package com.bblackbean.sboot.data.dao;

import com.bblackbean.sboot.data.entity.ProductEntity;

public interface ProductDAO {
    ProductEntity saveProduct(ProductEntity productEntity);

    ProductEntity getProduct(String productId);
}
