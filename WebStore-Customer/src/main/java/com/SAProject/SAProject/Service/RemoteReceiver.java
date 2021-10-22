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
    private CustomerService customerService;
    @Autowired
    private RemoteRequestSender remoteRequestSender;

    @KafkaListener(topics = "getCustomer")
    public void getCustomer(@Payload String customerId,
                                @Headers MessageHeaders headers) {
        CustomerAdaptor customerAdaptor = new CustomerAdaptor();
        getRemoteRequestSender().send(customerService.getCustomer(customerId));
    }
}
