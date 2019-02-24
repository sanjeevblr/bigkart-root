package com.edureka.jan26.mstraing.productservicetdd.repository;

import com.edureka.jan26.mstraing.productservicetdd.domain.Product;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {


    //SUT - System Under Test
    @Autowired
    ProductRepository productRepository;

    @Test
    public void shouldSaveProduct(){

        Product product = Product.builder()
                .id(1)
                .name("Samsumg S10")
                .description("Samsung S10 amoled 6.7 inches")
                .quantity(10)
                .build();

        productRepository.save(product);

        Optional<Product> byId = productRepository.findById(1);
        Assertions.assertThat(byId.isPresent());
        Assertions.assertThat(byId.get()).isEqualTo(product);

    }

    @Test
    public void shouldDeleteProduct(){

        Product product = Product.builder()
                .id(1)
                .name("Samsumg S10")
                .description("Samsung S10 amoled 6.7 inches")
                .quantity(10)
                .build();

        productRepository.save(product);
        productRepository.delete(product);

        Optional<Product> byId = productRepository.findById(1);
        Assertions.assertThat(!byId.isPresent());

    }
    @Test
    public void souldSaveProductWhenNoneOfTheFieldsAreNull(){

    }

    @Test
    public void souldNotSaveIfDescripitionIsNULL(){

    }

    @Test
    public void shouldReturnEligibleProductWithinAQuantityRange(){
        //Given
        Product firstProduct = createProduct(3, "name.1", "description.1", 4);
        Product secondProduct = createProduct(4, "name.2", "description.2", 5);
        Product thirdProduct = createProduct(5, "name.3", "description.3", 6);
        Product fourthProduct = createProduct(6, "name.4", "description.4", 7);

        productRepository.saveAll(Arrays.asList(firstProduct,secondProduct,thirdProduct,fourthProduct));

        //when
        List<Product> productsByQuantityBetween = productRepository.findProductsByQuantityBetween(4, 6);

        //Then
        Assertions.assertThat(productsByQuantityBetween.size()).isEqualTo(3);

    }

    private Product createProduct(int id, String name, String description, int quantity) {
        return Product.builder()
                .id(id)
                .name(name)
                .description(description)
                .quantity(quantity)
                .build();
    }
}