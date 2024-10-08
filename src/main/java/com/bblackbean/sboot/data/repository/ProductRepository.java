package com.bblackbean.sboot.data.repository;

import com.bblackbean.sboot.data.entity.ProductEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {   // JpaRepository를 상속받고있고, ProductEntity를 사용하고 PK 값의 타입은 String
    /* 쿼리 메소드의 주제 키워드 */

    // 조회
    List<ProductEntity> findByProductName(String name);
    List<ProductEntity> queryByProductName(String name);

    // 존재 유무
    boolean existsByProductName(String name);

    // 쿼리 결과 개수
    long countByProductName(String name);

    // 삭제
    void deleteByProductName(String name);
    long removeByProductName(String name);

    // 값 개수 제한
    List<ProductEntity> findFirst5ByProductName(String name);
    List<ProductEntity> findTop3ByProductName(String name);

    /* 쿼리 메소드의 조건자 키워드 */

    // Is, Equals (생략 가능)
    // Logical Keyword : IS , Keyword Expressions : Is, Equals, (or no keyword)
    // findByNumber 메소드와 동일하게 동작
    ProductEntity findByProductIdIs(String id);
    ProductEntity findByProductIdEquals(String id);

    // (Is)Not
    List<ProductEntity> findByProductIdNot(String id);
    List<ProductEntity> findByProductIdIsNot(String id);

    // (Is)Null, (Is)NotNull
    List<ProductEntity> findByProductStockIsNull();
    List<ProductEntity> findByProductStockIsNotNull();

    // And, Or
    List<ProductEntity> findTopByProductIdAndProductName(String id, String name);

    // (Is)GreaterThan, (Is)LessThan, (Is)Between
    List<ProductEntity> findByProductPriceGreaterThan(Integer price);

    // (Is)Like, (Is)Containing, (Is)StartingWith, (Is)EndingWith
    List<ProductEntity> findByProductNameContaining(String name);
}
