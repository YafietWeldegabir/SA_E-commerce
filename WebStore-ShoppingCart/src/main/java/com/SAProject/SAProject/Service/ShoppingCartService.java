package com.SAProject.SAProject.Service;

public interface ShoppingCartService {
    ShoppingCartDTO createCart();
    ShoppingCartDTO addProduct(String cartId, ProductDTO productDTO);
    ShoppingCartDTO removeProduct(String cartId, ProductDTO productDTO);
    ShoppingCartDTO changeProductQuantity(String cartId, String productId, int quantity) throws InterruptedException;
    ShoppingCartDTO checkOut(String cartId, String customerId);
}
