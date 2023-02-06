package com.example.rabbitmqproducer.service;

import com.example.rabbitmqproducer.config.RabbitmqConfig;
import com.example.rabbitmqproducer.model.MessageModel;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    @Autowired
    private RabbitmqConfig rabbitmqConfig;
    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(MessageModel message) {
        rabbitTemplate.convertAndSend(rabbitmqConfig.getExchanger(),rabbitmqConfig.getRoutingKey(), message);
        System.out.println("Send msg = " + message.getMessage());

    }
}
