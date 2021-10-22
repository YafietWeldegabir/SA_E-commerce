package com.SAProject.SAProject.Service;

import com.SAProject.SAProject.Repository.ProductRepo;
import com.SAProject.SAProject.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product addProduct(Product product) {
        System.out.println("Product creating: " + product.getProductNumber());
        return productRepo.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Optional<Product> product1 = productRepo.findById(product.getProductNumber());
        if(product1.isPresent()){
            Product product2 = product1.get();
            if(!product2.getName().equalsIgnoreCase(product.getName())) product2.setName(product.getName());
            if(product2.getPrice() != product.getPrice()) product2.setPrice(product.getPrice());
            if(product2.getQuantity() != product.getQuantity()) product2.setQuantity(product.getQuantity());
            if(!product2.getDescription().equalsIgnoreCase(product.getDescription())) product2.setDescription(product.getDescription());
            productRepo.save(product2);
            return product2;
        }
        return null;
    }

    @Override
    public ProductDTO getProduct(String id) {
        Optional<Product> product = productRepo.findById(id);
        return product.map(ProductAdaptor::toProductDTO).orElse(null);
    }

    @Override
    public Product deleteProduct(String id) {
        Optional<Product> product = productRepo.findById(id);
        if(product.isPresent()){
            productRepo.deleteById(id);
            return product.get();
        }
        return null;
    }

    @Override
    public Integer getQuantity(String id){
        ProductDTO product = getProduct(id);
        return product.getQuantity();
    }

}
