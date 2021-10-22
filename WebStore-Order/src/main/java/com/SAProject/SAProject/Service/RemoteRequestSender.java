//package com.SAProject.SAProject.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RemoteRequestSender {
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    private String topic ="getCustomer";
//
//    public void send(String customerId){
//        kafkaTemplate.send(topic, customerId);
//    }
//}
