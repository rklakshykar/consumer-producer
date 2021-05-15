package com.kafka.consumerproducer.controller;

import com.kafka.consumerproducer.service.KafKaProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {
    private static final Logger logger = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private  KafKaProducerService producerService;

    @GetMapping
    public  String welcome(){

        return "Hello";
    }

    @PostMapping(value = "/message/publish")
    public String sendMessageToKafkaTopic(@RequestParam("message") String message)
    {
        this.producerService.sendMessage(message);

        return "Message Published";
    }

}
