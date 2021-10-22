package com.SAProject.SAProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RemoteRequestSender {
    @Autowired
    private KafkaTemplate<String, CustomerDTO> kafkaTemplate;

    private String topic ="CustomerDTO";

    public void send(CustomerDTO customerDTO){
        kafkaTemplate.send(topic, customerDTO);
    }
}
