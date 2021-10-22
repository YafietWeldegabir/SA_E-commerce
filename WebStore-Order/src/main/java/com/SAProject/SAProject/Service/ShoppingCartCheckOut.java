package com.SAProject.SAProject.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartCheckOut {
    private String customerId;
    private ShoppingCartDTO shoppingCartDTO;
}
