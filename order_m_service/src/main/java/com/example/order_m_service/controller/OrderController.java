package com.example.order_m_service.controller;

import com.example.order_m_service.kafka.OrderProducer;
import com.example.order_m_service.model.Order;
import com.example.order_m_service.model.OrderEvent;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/food/order")
public class OrderController {
    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/status")
    public  String placeOrder(@RequestBody Order order){
         order.setOrderID(UUID.randomUUID().toString());

        OrderEvent orderEvent=new OrderEvent();
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);

        return  "Order placed sucessfully";
    }
}
