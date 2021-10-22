package com.SAProject.SAProject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartChangeSender {


    @Autowired
    private KafkaTemplate<String, ShoppingCartChangeEventDTO> kafkaTemplate;
    @Autowired
    private KafkaTemplate<String, ShoppingCartCheckOut> kafkaTemplate1;

//    @Value("${app.topic.ownertopic}")
    private String topic = "cartChange";
    private String topic1 = "placeOrder";

    public void send(ShoppingCartChangeEventDTO shoppingCartChangeEventDTO){
        kafkaTemplate.send(topic, shoppingCartChangeEventDTO);
    }

    public void checkOut(ShoppingCartCheckOut shoppingCartCheckOut){
        System.out.println("now sending to order");
        kafkaTemplate1.send(topic1, shoppingCartCheckOut);
    }

}
