package com.SAProject.SAProject.Domain;

import java.time.LocalDate;
import java.util.ArrayList;

public class ShoppingCartServiceDomain {
    IdGenerator idGenerator = new IdGenerator();

    public ShoppingCart createShoppingCart(){

        return new ShoppingCart(idGenerator.generate(), LocalDate.now(), new ArrayList<>());
    }

    public ShoppingCart addProduct(ShoppingCart shoppingCart, Product product){
        shoppingCart.addProduct(product);
        return shoppingCart;
    }

    public ShoppingCart removeProduct(ShoppingCart shoppingCart, Product product){
        shoppingCart.removeProduct(product);
        return shoppingCart;
    }

    public ShoppingCart changeQuantity(ShoppingCart shoppingCart, String id, int quantity){
        shoppingCart.changeQuantity(id, quantity);
        return shoppingCart;
    }
    public Product getProduct(ShoppingCart shoppingCart, String id){
        return shoppingCart.getProduct(id);
    }
}
