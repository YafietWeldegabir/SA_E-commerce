package com.SAProject.SAProject.Service;

import com.SAProject.SAProject.Domain.ShoppingCart;

public class ShoppingCartAdaptor {

    public ShoppingCartDTO toShoppingCartDTO(ShoppingCart shoppingCart){
        return new ShoppingCartDTO(shoppingCart.getCartNumber(),shoppingCart.getDate(), shoppingCart.getProducts());
    }
}
