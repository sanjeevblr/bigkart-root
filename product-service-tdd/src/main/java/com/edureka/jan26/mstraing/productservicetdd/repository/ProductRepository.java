package com.edureka.jan26.mstraing.productservicetdd.repository;

import com.edureka.jan26.mstraing.productservicetdd.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findProductsByQuantityBetween(int min, int max);
}
