package com.ms.orderservice.service;

import com.ms.orderservice.dto.OrderRequest;
import com.ms.orderservice.model.Order;
import com.ms.orderservice.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    public void placeOrder(OrderRequest orderRequest) {
        //map order request to order object
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setSkuCode(orderRequest.skuCode());
        order.setQuantity(orderRequest.quantity());
        order.setStatus(orderRequest.status());
        //save order to db
        orderRepo.save(order);
    }
}
