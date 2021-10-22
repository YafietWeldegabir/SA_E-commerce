//package com.WebStoreShoppingCart.WebStoreShoppingCart.Service;
//
//import lombok.Getter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.MessageHeaders;
//import org.springframework.messaging.handler.annotation.Headers;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Service;
//
//@Service
//@Getter
//public class ProductQuantityRequestListener {
//
//    private int amount = 0;
//
//    @KafkaListener(topics = "topic1")
//    public Integer receive(@Payload Integer amount,
//                        @Headers MessageHeaders headers) {
//        System.out.println(amount  + " amount");
//        return this.amount = amount;
//    }
//
//
//
//
//}
