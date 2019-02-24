package com.edureka.jan26.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    int id;

    String name;

    String description;

    int quantity;

}
