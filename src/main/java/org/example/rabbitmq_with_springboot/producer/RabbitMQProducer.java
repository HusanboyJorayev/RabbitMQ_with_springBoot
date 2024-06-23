package org.example.rabbitmq_with_springboot.producer;


import lombok.RequiredArgsConstructor;
import org.example.rabbitmq_with_springboot.dto.Dto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class RabbitMQProducer {
    private static final Logger LOGGER = Logger.getLogger(RabbitMQProducer.class.getName());

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.routing.key.name}")
    private String routingKey;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    public void send(String message) {
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        LOGGER.info(String.format("Sent message: %s", message));
    }
    public void sendJson(Dto dto) {
        LOGGER.info(String.format("Sent message: %s", dto.toString()));
        rabbitTemplate.convertAndSend(exchange, routingKey, dto);
    }
}
