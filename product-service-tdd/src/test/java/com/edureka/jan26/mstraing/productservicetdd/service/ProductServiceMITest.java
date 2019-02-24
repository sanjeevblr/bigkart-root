package com.edureka.jan26.mstraing.productservicetdd.service;

import com.edureka.jan26.mstraing.productservicetdd.domain.Product;
import com.edureka.jan26.mstraing.productservicetdd.domain.ProductRequest;
import com.edureka.jan26.mstraing.productservicetdd.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductServiceMITest {

    @Autowired
    ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @Test
    public void test(){
        ProductRequest productRequest = ProductRequest.builder()
                .id(1)
                .name("Samsumg S10")
                .description("Samsung S10 amoled 6.7 inches")
                .quantity(10)
                .build();

        Product product = Product.builder()
                .id(1)
                .name("Samsumg S10")
                .description("Samsung S10 amoled 6.7 inches")
                .quantity(10)
                .build();

        productService.save(productRequest);

        Optional<Product> byId = productRepository.findById(1);
        Assertions.assertThat(byId.isPresent());
        Assertions.assertThat(byId.get()).isEqualTo(product);
    }
}
