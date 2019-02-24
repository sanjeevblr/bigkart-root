package com.edureka.jan26.mstraing.orderservice.resource;

import com.edureka.jan26.mstraing.orderservice.exception.OrderNotCreatedException;
import com.edureka.jan26.mstraing.orderservice.model.Order;
import com.edureka.jan26.mstraing.orderservice.model.OrderRequest;
import com.edureka.jan26.mstraing.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "order")
public class OrderResource {

    @Autowired
    OrderService orderService;

    @PostMapping
    @RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> createOrder(@RequestBody OrderRequest orderRequest){
        if(orderService.createOrder(orderRequest)!=null){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            throw new OrderNotCreatedException();
        }
    }

    @GetMapping
    //@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> isOrderPresent(@RequestParam Integer id){
        return ResponseEntity.ok(orderService.isOrderPresent(id));
    }

}
