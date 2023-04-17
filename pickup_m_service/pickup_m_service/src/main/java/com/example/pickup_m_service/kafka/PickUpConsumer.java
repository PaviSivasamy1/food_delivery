package com.example.pickup_m_service.kafka;

import com.example.order_m_service.model.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PickUpConsumer {

    private static final Logger LOGGER= LoggerFactory.getLogger(PickUpConsumer.class);

    @KafkaListener(topics="${spring.kafka.topic.name}",
    groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent){
        OrderEvent orderEvent1=new OrderEvent();
        orderEvent1.setMessage("order ready for delivery");
        orderEvent1.setStatus("Delivery partner picked ur order");

        LOGGER.info(String.format("Order Picked Up %s",orderEvent1.toString()));

    }
}
