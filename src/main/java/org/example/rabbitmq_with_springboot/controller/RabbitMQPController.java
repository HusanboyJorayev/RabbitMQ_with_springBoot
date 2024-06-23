package org.example.rabbitmq_with_springboot.controller;

import lombok.RequiredArgsConstructor;
import org.example.rabbitmq_with_springboot.dto.Dto;
import org.example.rabbitmq_with_springboot.producer.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/message")
public class RabbitMQPController {
    private final RabbitMQProducer rabbitMQProducer;

    @GetMapping("/publish")
    public ResponseEntity<?> sendMessage(@RequestParam("message") String message) {
        this.rabbitMQProducer.send(message);
        return ResponseEntity.ok().body("Message sent to RabbitMQ");

    }

    @PostMapping("/json-publish")
    public ResponseEntity<?> sendJsonMessage(@RequestBody Dto dto) {
        this.rabbitMQProducer.sendJson(dto);
        return ResponseEntity.ok().body("Message sent to RabbitMQ");
    }
}
