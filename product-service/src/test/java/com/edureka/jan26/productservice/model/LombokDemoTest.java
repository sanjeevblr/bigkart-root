package com.edureka.jan26.productservice.model;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class LombokDemoTest {

    @Test
    public void testGetterAndSetter(){
        LombokDemo lombokDemo = new LombokDemo();
        lombokDemo.setId(34);


        LombokDemo lombokDemo1 = LombokDemo.builder().id(23).name("name").build();

        Assertions.assertThat(lombokDemo.getId()).isEqualTo(34);
    }

}