package com.edureka.jan26.mstraing.orderservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

    Integer id;

    int userId;

    ProductDetail productDetail;

    int quantity;

    String address;


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ProductDetail {

        int code;

        String name;

        String description;

    }
}
