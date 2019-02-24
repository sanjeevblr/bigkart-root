package com.edureka.jan26.mstraing.orderservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "product_order", catalog = "ms")
public class Order {

    @Id
    @Column(name = "id")
    Integer id;

    @Column(name = "user_id")
    int userId;

    @Embedded
    ProductDetail productDetail;

    @Column(name = "quantity")
    int quantity;

    @Column(name = "address")
    String address;
    private String status;

    public void setStatus(String status) {

        this.status = status;
    }

    public String getStatus() {
        return status;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder

    @Embeddable
    public static class ProductDetail {

        @Column(name = "code")
        int code;

        @Column(name = "name")
        String name;

        @Column(name = "description")
        String description;

    }
}
