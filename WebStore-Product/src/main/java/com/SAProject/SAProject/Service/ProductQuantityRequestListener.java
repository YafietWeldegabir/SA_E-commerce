//package com.WebStoreProduct.WebStoreProduct.Service;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.messaging.MessageHeaders;
//import org.springframework.messaging.handler.annotation.Headers;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProductQuantityRequestListener {
//
//    @Autowired
//    private ProductService productService;
//    @Autowired
//    private ProductQuantitySender productQuantitySender;
//
//    @KafkaListener(topics = "topic2")
//    public void receive(@Payload String productId,
//                        @Headers MessageHeaders headers) {
//        productQuantitySender.send(productService.getQuantity(productId));
//    }
//
//}
