package com.SAProject.SAProject.Service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Data
public class RemoteReceiver {
    @Autowired
    private OrderServiceImpl orderService;


    @KafkaListener(topics = "placeOrder")
    public void receiveCheckOut(@Payload ShoppingCartCheckOut shoppingCartCheckOut,
                                @Headers MessageHeaders headers) {
        System.out.println("just received from cart");
        orderService.placeOrder(shoppingCartCheckOut);

    }
}
