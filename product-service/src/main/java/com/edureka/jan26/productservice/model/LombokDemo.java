package com.edureka.jan26.productservice.model;


import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
@ToString

public class LombokDemo {

    private int id;

    private String name;

}
