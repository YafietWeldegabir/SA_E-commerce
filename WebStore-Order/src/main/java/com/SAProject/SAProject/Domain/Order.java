package com.SAProject.SAProject.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    private String orderId;
    private Customer customer;
    private ShoppingCart shoppingCart;

    public String printOrder(){
        return  "Order id = " + orderId + '\'' + ", Customer Detail = " + customer.toString() + '\'' + shoppingCart.print();
    }

}
