package com.SAProject.SAProject.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class ShoppingCart {
    @Id
    private String cartNumber;
    private LocalDate date;
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product){
        boolean present = products.stream().anyMatch(product1 -> product1.getProductNumber().equalsIgnoreCase(product.getProductNumber()));
        if(!present) products.add(product);
    }

    public void removeProduct(Product product){
        products.removeIf(p -> p.getProductNumber().equalsIgnoreCase(product.getProductNumber()));
    }

    public void changeQuantity(String id, int quantity){
        Optional<Product> product = products.stream().filter(product1 -> product1.getProductNumber().equalsIgnoreCase(id)).findFirst();
        if(product.isPresent()){
            Product newProduct = new Product(product.get().getProductNumber(),product.get().getName(),product.get().getPrice(),product.get().getDescription(),quantity);
            removeProduct(product.get());
            addProduct(newProduct);
        }
    }

    public Product getProduct(String id){
        boolean present = products.stream().anyMatch(product1 -> product1.getProductNumber().equalsIgnoreCase(id));
        if(present){
            for(Product p: products){
                if(p.getProductNumber().equalsIgnoreCase(id)) return p;
            }
        }
        return null;
    }
}
