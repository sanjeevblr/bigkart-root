package com.edureka.jan26.mstraing.productservicetdd.service;

import com.edureka.jan26.mstraing.productservicetdd.domain.Product;
import com.edureka.jan26.mstraing.productservicetdd.domain.ProductRequest;
import com.edureka.jan26.mstraing.productservicetdd.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;


public class ProductServiceTest {


    //SUT
    ProductService productService;

    @Before
    public void beforeTest(){
        productService = new ProductService();
        productService.productRepository = Mockito.mock(ProductRepository.class);
    }


    @Test
    public void shouldSaveAProduct(){
        //Given
        ProductRequest productRequest = ProductRequest.builder()
                .id(1)
                .name("name.1")
                .description("description.1")
                .quantity(5)
                .build();

        Product expectedProduct = Product.builder()
                .id(1)
                .name("name.1")
                .description("description.1")
                .quantity(5)
                .build();


        boolean saved = productService.save(productRequest);

        Assertions.assertThat(saved).isTrue();

        ArgumentCaptor<Product> argumentCaptor = ArgumentCaptor.forClass(Product.class);

        //Performance - it is rolling to performance but not performance test.
        Mockito.verify(productService.productRepository, Mockito.times(1)).save(argumentCaptor.capture());

        Product actualProduct = argumentCaptor.getValue();

        Assertions.assertThat(actualProduct).isEqualTo(expectedProduct);


    }


}
