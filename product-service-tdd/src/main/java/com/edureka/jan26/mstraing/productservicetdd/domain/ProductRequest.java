package com.edureka.jan26.mstraing.productservicetdd.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {

    int id;

    String name;

    String description;

    int quantity;

}
