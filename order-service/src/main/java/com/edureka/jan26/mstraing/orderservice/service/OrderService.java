package com.edureka.jan26.mstraing.orderservice.service;

import com.edureka.jan26.mstraing.orderservice.exception.OrderNotCreatedException;
import com.edureka.jan26.mstraing.orderservice.model.Order;
import com.edureka.jan26.mstraing.orderservice.model.OrderRequest;
import com.edureka.jan26.mstraing.orderservice.respository.OrderRepository;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    RestTemplate restTemplate;

    public Order createOrder(OrderRequest orderRequest){
        Order order = new OrderTransformer().transform(orderRequest);

        //Open Issue
        //1. Hystrix
        //2. Feign
        //
        orderRepository.save(order); // Commited

        ResponseEntity<Boolean> forEntity = restTemplate.getForEntity("http://product-service/product?id=" + orderRequest.getProductDetail().getCode(), Boolean.class);


        if(forEntity.getBody()){
            return orderRepository.save(order);
        }else{
            order.setStatus("abondoned");
            orderRepository.save(order);
            throw new OrderNotCreatedException();
        }
    }

    public Boolean isOrderPresent(Integer orderId) {
        Optional<Order> byId = orderRepository.findById(orderId);
        return byId.isPresent();
    }

    private class OrderTransformer {
        public Order transform(OrderRequest orderRequest) {
            return Order.builder()
                    .id(orderRequest.getId())
                    .address(orderRequest.getAddress())
                    .productDetail(Order.ProductDetail.builder()
                            .code(orderRequest.getProductDetail().getCode())
                            .name(orderRequest.getProductDetail().getName())
                            .description(orderRequest.getProductDetail().getDescription())
                            .build())
                    .quantity(orderRequest.getQuantity())
                    .userId(orderRequest.getUserId())
                    .build();
        }
    }
}
