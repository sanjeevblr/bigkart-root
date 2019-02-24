package com.edureka.jan26.productservice.repository;

import com.edureka.jan26.productservice.model.Product;
import com.edureka.jan26.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {


}
