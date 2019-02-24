package com.edureka.jan26.mstraing.productservicetdd.resource;


import com.edureka.jan26.mstraing.productservicetdd.domain.ProductRequest;
import com.edureka.jan26.mstraing.productservicetdd.exception.ProductNotCreatedException;
import com.edureka.jan26.mstraing.productservicetdd.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "product")
public class ProductResource {


    @Autowired
    ProductService productService;

    @PostMapping
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveProduct(@RequestBody ProductRequest productRequest){

        if(productRequest.getId() < 0){ //Invalid Id
            return ResponseEntity.ok(productRequest);
        }


        boolean saved = productService.save(productRequest);
        if(saved){
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("true");
        }else{
            throw new ProductNotCreatedException();
        }
    }

    /*@GetMapping
    public ResponseEntity<Boolean> isProductInInventory(int id){
        boolean exists = productService.isProductExists(id);
        return ResponseEntity.status(HttpStatus.OK).body(exists);
    }*/


}
