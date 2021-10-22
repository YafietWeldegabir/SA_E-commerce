package com.SAProject.SAProject.Service;

import com.SAProject.SAProject.Domain.Product;

public interface ProductService {
    Product addProduct(Product product);
    Product updateProduct(Product product);
    ProductDTO getProduct(String id);
    Product deleteProduct(String id);
    Integer getQuantity(String id);
}
