package org.example.rabbitmq_with_springboot.consumer;

import lombok.RequiredArgsConstructor;
import org.example.rabbitmq_with_springboot.dto.Dto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RabbitMQConsumer {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void consume(String message) {
        logger.info(String.format("received message: %s", message));
    }

    @RabbitListener(queues = "${rabbitmq.queue.name}")
    public void jsonConsume(Dto dto) {
        logger.info(String.format("received message: %s", dto.toString()));
    }
}
