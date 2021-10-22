package com.SAProject.SAProject.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Product {
    private String productNumber;
    private String name;
    private double price;
    private String description;
    private int quantity;

    public double calculatePrice(){
        return quantity*price;
    }
    public String printProduct(){
       return "Product number = " + getProductNumber()+ ", Name= " + getName() + ", Quantity = " + getQuantity() + ", TotalPrice = " + calculatePrice();
    }
}
