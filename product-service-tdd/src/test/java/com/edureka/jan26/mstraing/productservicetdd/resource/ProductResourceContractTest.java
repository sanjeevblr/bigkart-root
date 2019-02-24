package com.edureka.jan26.mstraing.productservicetdd.resource;


import com.edureka.jan26.mstraing.productservicetdd.domain.ProductRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductResourceContractTest {


    @Autowired
    MockMvc mockMvc;


    @Test
    public void shouldSaveTheProduct() throws Exception {

        //Given
        ProductRequest productRequest = ProductRequest.builder()
                .id(-1)
                .name("name.1")
                .description("description.1")
                .quantity(1)
                .build();
        //When - when I do invoke the API

        ObjectMapper objectMapper = new ObjectMapper();
        String valueAsString = objectMapper.writeValueAsString(productRequest);


        mockMvc.perform(
                post("/product")
                        .contentType("application/json")
                        .accept("application/json")
                        .content(valueAsString)
        ).andDo(print())
                .andExpect(content().string(valueAsString));

    }

}
