package com.example.delivery_m_service.kafka;

import com.example.order_m_service.model.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class DeliveryConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(DeliveryConsumer.class);

    @KafkaListener(topics="${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEvent orderEvent){


        LOGGER.info(String.format("Order Picked Up %s",orderEvent.toString()));

    }
}
