//package com.WebStoreShoppingCart.WebStoreShoppingCart.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProductQuantitySender {
//
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    private String topic ="topic2";
//
//    public void send(String productId){
//        kafkaTemplate.send(topic, productId);
//    }
//
//}
