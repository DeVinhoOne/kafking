package com.example.senderservice.services;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class SenderService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${custom.kafka.topic.main}")
    private String mainTopicName;

    @PostConstruct
    public void sendTestMessageToKafkaTopic() {
        kafkaTemplate.send(mainTopicName, "Hello, it's test message from sender-service. Time: " + LocalDateTime.now());
    }
}
