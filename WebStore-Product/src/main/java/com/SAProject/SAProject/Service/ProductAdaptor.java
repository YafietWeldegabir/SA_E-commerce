package com.SAProject.SAProject.Service;


import com.SAProject.SAProject.Domain.Product;

public class ProductAdaptor {

    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(product.getProductNumber(),product.getName(),product.getPrice(),product.getDescription(),product.getQuantity());
    }

    public static Product toProduct(ProductDTO productDTO){
        return new Product(productDTO.getProductNumber(),productDTO.getName(),productDTO.getPrice(),productDTO.getDescription(),productDTO.getQuantity());
    }
}
