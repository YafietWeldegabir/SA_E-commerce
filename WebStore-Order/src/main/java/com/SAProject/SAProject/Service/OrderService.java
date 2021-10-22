package com.SAProject.SAProject.Service;

import com.SAProject.SAProject.Domain.Order;

import java.util.List;

public interface OrderService {
    void placeOrder(ShoppingCartCheckOut shoppingCartCheckOut);
    Order getOrder(String orderId);

    List<Order> getOrder();
}
