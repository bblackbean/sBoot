package com.bblackbean.sboot.data.repository;

import com.bblackbean.sboot.data.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {   // JpaRepository를 상속받고있고, ProductEntity를 사용하고 PK 값의 타입은 String
}
