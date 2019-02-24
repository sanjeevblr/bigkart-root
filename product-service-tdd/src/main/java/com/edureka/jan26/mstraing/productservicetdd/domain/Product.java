package com.edureka.jan26.mstraing.productservicetdd.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "product", catalog = "ms")
public class Product {

    @Id
    @Column(name = "id")
    Integer id;

    @Column(name = "description", nullable = false)
    String description;

    @Column(name = "name")
            @Size(max = 30, message = "Name should not be more than 30")
    String name;

    @Column(name = "quantity")

    @Max(value = 50000)
    @Min(value = 25)
    @Positive

    Integer quantity;

    @Email
    String email;

}
