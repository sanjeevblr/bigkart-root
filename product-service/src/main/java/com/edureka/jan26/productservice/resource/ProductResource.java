package com.edureka.jan26.productservice.resource;

import com.edureka.jan26.productservice.exception.ProductNotCreatedException;
import com.edureka.jan26.productservice.model.ProductRequest;
import com.edureka.jan26.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "product")
public class ProductResource {


    @Autowired
    ProductService productService;

    @PostMapping
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveProduct(@RequestBody ProductRequest productRequest){
        boolean saved = productService.save(productRequest);
        if(saved){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            throw new ProductNotCreatedException();
        }
    }

    @GetMapping
    public ResponseEntity<Boolean> isProductInInventory(int id){
        boolean exists = productService.isProductExists(id);
        return ResponseEntity.status(HttpStatus.OK).body(exists);
    }
}
