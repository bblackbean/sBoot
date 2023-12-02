package com.bblackbean.sboot.data.handler.impl;

import com.bblackbean.sboot.data.dao.ProductDAO;
import com.bblackbean.sboot.data.entity.ProductEntity;
import com.bblackbean.sboot.data.handler.ProductDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {
    ProductDAO productDAO;

    @Autowired
    public ProductDataHandlerImpl(ProductDAO productDAO) {this.productDAO = productDAO;}

    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock) {
        // 받은 값들을 엔티티로 생성, DAO 쪽으로 보내서 저장
        ProductEntity productEntity = new ProductEntity(productId, productName, productPrice, productStock);

        return productDAO.saveProduct(productEntity);
    }

    @Override
    public ProductEntity getProductEntity(String productId) {
        return productDAO.getProduct(productId);
    }


}
