package com.SAProject.SAProject.Service;

import com.SAProject.SAProject.Domain.ShoppingCart;

public class ShoppingCartAdaptor {
    public ShoppingCart toShoppingCart(ShoppingCartDTO shoppingCartDTO){
        return new ShoppingCart(shoppingCartDTO.getCartNumber(),shoppingCartDTO.getDate(),shoppingCartDTO.getProducts());
    }
    public ShoppingCartDTO toShoppingCartDTO(ShoppingCart shoppingCart){
        return new ShoppingCartDTO(shoppingCart.getCartNumber(), shoppingCart.getDate(), shoppingCart.getProducts());
    }
}
