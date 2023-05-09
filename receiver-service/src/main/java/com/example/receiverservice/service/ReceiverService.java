package com.example.receiverservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReceiverService {
    @KafkaListener(topics = "${custom.kafka.topic.main}", groupId = "${custom.kafka.group}")
    public void listenToMessage(String message) {
        log.info(message);
    }
}
