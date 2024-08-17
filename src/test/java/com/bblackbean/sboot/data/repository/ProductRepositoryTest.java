package com.bblackbean.sboot.data.repository;

import com.bblackbean.sboot.data.entity.ProductEntity;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//@SpringBootTest(classes = {ProductDataHandlerImpl.class, ProductServiceImpl.class, ProductRepository.class})
@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    ProductRepository productRepository;

    @BeforeEach
    void GenerateData() {
        int count = 1;
        productRepository.save(getProduct(Integer.toString(count), count++, 2000, 3000));
        productRepository.save(getProduct(Integer.toString(count), count++, 3000, 3000));
        productRepository.save(getProduct(Integer.toString(--count), count = count + 2, 1500, 200));
        productRepository.save(getProduct(Integer.toString(count), count++, 4000, 3000));
        productRepository.save(getProduct(Integer.toString(count), count++, 10000, 1500));
        productRepository.save(getProduct(Integer.toString(count), count++, 10000, 1000));
        productRepository.save(getProduct(Integer.toString(count), count++, 500, 10000));
        productRepository.save(getProduct(Integer.toString(count), count++, 8500, 3500));
        productRepository.save(getProduct(Integer.toString(count), count++, 1000, 2000));
        productRepository.save(getProduct(Integer.toString(count), count, 5100, 1700));
    }

    private ProductEntity getProduct(String id, int nameNumber, int price, int stock) {
        return new ProductEntity(id, "상품" + nameNumber, price, stock);
    }

    @Test
    void findTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundEntities = productRepository.findByProductName("상품4");

        for (ProductEntity product : foundEntities) {
            System.out.println(product.toString());
        }

        List<ProductEntity> queryEntities = productRepository.queryByProductName("상품4");

        for (ProductEntity product : queryEntities) {
            System.out.println(product.toString());
        }
    }

    @Test
    void existTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        System.out.println(productRepository.existsByProductName("상품4"));
        System.out.println(productRepository.existsByProductName("상품2"));
    }

    @Test
    void countTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        System.out.println(productRepository.countByProductName("상품4"));
    }

    @Test
    @Transactional
    void deleteTest() {
        System.out.println("before : " + productRepository.count());

        productRepository.deleteByProductName("상품1");
        productRepository.removeByProductName("상품9");

        System.out.println("After : " + productRepository.count());
    }

    @Test
    void topTest() {
        productRepository.save(getProduct("109", 123, 1500, 5000));
        productRepository.save(getProduct("101", 123, 2500, 5000));
        productRepository.save(getProduct("102", 123, 3500, 5000));
        productRepository.save(getProduct("103", 123, 4500, 5000));
        productRepository.save(getProduct("104", 123, 1000, 5000));
        productRepository.save(getProduct("105", 123, 2000, 5000));
        productRepository.save(getProduct("106", 123, 3000, 5000));
        productRepository.save(getProduct("107", 123, 4000, 5000));

        List<ProductEntity> foundEntities = productRepository.findFirst5ByProductName("상품123");
        for (ProductEntity product : foundEntities) {
            System.out.println(product.toString());
        }

        List<ProductEntity> foundEntities2 = productRepository.findTop3ByProductName("상품123");
        for (ProductEntity product : foundEntities2) {
            System.out.println(product.toString());
        }
    }

    /* ↓↓ 조건자 키워드 테스트 ↓↓ */

    @Test
    void isEqualsTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        System.out.println(productRepository.findByProductIdIs("1"));
        System.out.println(productRepository.findByProductIdEquals("1"));
    }

    @Test
    void notTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundEntities = productRepository.findByProductIdNot("1");
        for (ProductEntity product : foundEntities) {
            System.out.println(product);
        }
        // System.out.println(productRepository.findByProductIdNot("1"));
        System.out.println(productRepository.findByProductIdIsNot("1"));
    }

    @Test
    void nullTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        System.out.println(productRepository.findByProductStockIsNull());
        System.out.println(productRepository.findByProductStockIsNotNull());
    }

    //@Test
    void andTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        System.out.println(productRepository.findTopByProductIdAndProductName("1", "상품1"));
    }

    @Test
    void greaterTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> productEntities = productRepository.findByProductPriceGreaterThan(5000);

        for (ProductEntity product : productEntities) {
            System.out.println(product);
        }
    }

    @Test
    void containTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        System.out.println(productRepository.findByProductNameContaining("상품1"));
    }

    /* 정렬과 페이징 */
    /*@Test
    void orderByTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundProducts = productRepository.findByProductNameContainingOrderByStockAsc("상품");
        for (ProductEntity product : foundProducts) {
            System.out.println(product);
        }

        foundProducts = productRepository.findByProductNameContainingOrderByStockDesc("상품");
        for (ProductEntity product : foundProducts) {
            System.out.println(product);
        }
    }

    //@Test
    void multiOrderByTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundProducts =
            productRepository.findByProductNameContainingOrderByPriceAscStockDesc("상품");
        for (ProductEntity product : foundProducts) {
            System.out.println(product);
        }
    }

    //@Test
    void orderByWithParameterTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundProducts =
            productRepository.findByProductNameContaining("상품", Sort.by(Order.asc("price")));
        for (ProductEntity product : foundProducts) {
            System.out.println(product);
        }

        foundProducts =
            productRepository.findByProductNameContaining(
                "상품", Sort.by(Order.asc("price"), Order.asc("stock")));
        for (ProductEntity product : foundProducts) {
            System.out.println(product);
        }
    }

    //@Test
    void pagingTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundProducts =
            productRepository.findByProductPriceGreaterThan(200, PageRequest.of(0, 2));
        for (ProductEntity product : foundProducts) {
            System.out.println(product);
        }

        foundProducts = productRepository.findByProductPriceGreaterThan(200, PageRequest.of(4, 2));
        for (ProductEntity product : foundProducts) {
            System.out.println(product);
        }
    }

    //@Test
    public void queryTest() {
        List<Product> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (Product product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundProducts = productRepository.findByProductPriceBasis();
        for (ProductEntity product : foundProducts) {
            System.out.println(product);
        }
    }

    //@Test
    public void nativeQueryTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundProducts = productRepository.findByProductPriceBasisNativeQuery();
        for (ProductEntity product : foundProducts) {
            System.out.println(product);
        }
    }

    //@Test
    public void parameterQueryTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundProducts = productRepository.findByProductPriceWithParameter(2000);
        for (ProductEntity product : foundProducts) {
            System.out.println(product);
        }
    }

    //@Test
    public void parameterNamingQueryTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundProducts = productRepository.findByProductPriceWithParameterNaming(2000);
        for (ProductEntity product : foundProducts) {
            System.out.println(product);
        }
    }

    //@Test
    public void parameterNamingQueryTest2() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundProducts = productRepository.findByProductPriceWithParameterNaming2(2000);
        for (ProductEntity product : foundProducts) {
            System.out.println(product);
        }
    }

    //@Test
    public void nativeQueryPagingTest() {
        List<ProductEntity> foundAll = productRepository.findAll();
        System.out.println("====↓↓ Test Data ↓↓====");
        for (ProductEntity product : foundAll) {
            System.out.println(product.toString());
        }
        System.out.println("====↑↑ Test Data ↑↑====");

        List<ProductEntity> foundProducts =
            productRepository.findByProductPriceWithParameterPaging(2000, PageRequest.of(2, 2));
        for (ProductEntity product : foundProducts) {
            System.out.println(product);
        }
    }

    //@Test
    public void basicCRUDTest() {
        *//* create *//*
        // given
        ProductEntity product =
            ProductEntity.builder().id("testProduct").name("testP").price(1000).stock(500).build();

        // when
        ProductEntity savedEntity = productRepository.save(product);

        // then
        Assertions.assertThat(savedEntity.getId()).isEqualTo(product.getId());
        Assertions.assertThat(savedEntity.getName()).isEqualTo(product.getName());
        Assertions.assertThat(savedEntity.getPrice()).isEqualTo(product.getPrice());
        Assertions.assertThat(savedEntity.getStock()).isEqualTo(product.getStock());

        *//* read *//*
        // when
        ProductEntity selectedEntity =
            productRepository.findById("testProduct").orElseThrow(RuntimeException::new);

        // then
        Assertions.assertThat(selectedEntity.getId()).isEqualTo(product.getId());
        Assertions.assertThat(selectedEntity.getName()).isEqualTo(product.getName());
        Assertions.assertThat(selectedEntity.getPrice()).isEqualTo(product.getPrice());
        Assertions.assertThat(selectedEntity.getStock()).isEqualTo(product.getStock());
    }*/


}
