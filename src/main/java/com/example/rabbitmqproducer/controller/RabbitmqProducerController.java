package com.example.rabbitmqproducer.controller;

import com.example.rabbitmqproducer.model.MessageModel;
import com.example.rabbitmqproducer.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RabbitmqProducerController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping(value = "/send")
    public String producer(@RequestParam("msg") String message) {
        MessageModel messageModel = new MessageModel();
        messageModel.setMessage(message);
        System.out.println(message);

        publisherService.send(messageModel);

        return "Message sent to the RabbitMQ  Successfully";
    }
}
