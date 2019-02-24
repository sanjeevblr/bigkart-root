package com.edureka.jan26.mstraing.orderservice.advice;

import com.edureka.jan26.mstraing.orderservice.exception.OrderNotCreatedException;
import com.edureka.jan26.mstraing.orderservice.model.Order;
import com.edureka.jan26.mstraing.orderservice.respository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductAdvice {

    @Autowired
    OrderRepository orderRepository;


    @ExceptionHandler(OrderNotCreatedException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public void rollbackProductCommit(/*Contextual information*/){

        Order order = new Order();
        order.setStatus("abondoned");

        orderRepository.save(order);
        //rollback the transaction

    }
}
