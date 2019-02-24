package com.edureka.jan26.mstraing.productservicetdd.service;

import com.edureka.jan26.mstraing.productservicetdd.domain.Product;
import com.edureka.jan26.mstraing.productservicetdd.domain.ProductRequest;
import com.edureka.jan26.mstraing.productservicetdd.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

@Service
public class ProductService {

    @Autowired
    protected ProductRepository productRepository;

    public boolean save(ProductRequest productRequest) {
        productRepository.save(new ProductTransformer().transform(productRequest));
        return true;
    }

    private class ProductTransformer {
        public Product transform(ProductRequest productRequest) {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();

            validator.validate(null/*TODO - pass the product*/);
            return Product.builder()
                    .id(productRequest.getId())
                    .name(productRequest.getName())
                    .description(productRequest.getDescription())
                    .quantity(productRequest.getQuantity())
                    .build();
        }
    }
}