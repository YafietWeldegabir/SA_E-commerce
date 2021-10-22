//package com.WebStoreProduct.WebStoreProduct.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProductQuantitySender {
//
//    @Autowired
//    private KafkaTemplate<String, Integer> kafkaTemplate;
//
//    private String topic ="topic1";
//
//    public void send(Integer quantity){
//        kafkaTemplate.send(topic, quantity);
//    }
//
//}
