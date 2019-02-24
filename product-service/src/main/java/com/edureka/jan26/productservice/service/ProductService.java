package com.edureka.jan26.productservice.service;

import com.edureka.jan26.productservice.model.Product;
import com.edureka.jan26.productservice.model.ProductRequest;
import com.edureka.jan26.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;

    public boolean save(ProductRequest productRequest) {

        Product product = Product.builder()
                .description(productRequest.getDescription())
                .name(productRequest.getName())
                .id(productRequest.getId())
                .quantity(productRequest.getQuantity())
                .build();


        Product saved = productRepository.save(product); // assumption is saved not null means it is saved in DB

        //TODO - SAGA Design pattern
        //trying to call to an another service and if the business transaction fails.
        //Global transaction handler will manage the call graph

        //Roll back the save - how would I do that?
        //product.setState(NOT_IN_INVENTORY);
        productRepository.save(product);


        return saved != null;
    }

    public boolean isProductExists(int id) {
        return productRepository.existsById(id);
    }
}
