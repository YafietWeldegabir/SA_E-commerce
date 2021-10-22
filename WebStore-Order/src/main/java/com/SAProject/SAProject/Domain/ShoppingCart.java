package com.SAProject.SAProject.Domain;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingCart {
    private String cartNumber;
    private LocalDate date;
    private List<Product> products = new ArrayList<>();

    private String calculateTotalPrice(){
        StringBuilder pro = new StringBuilder();
        for(Product p: products){
            String temp = "";
            temp = p.printProduct() + '\'';
            pro.append(temp);
        }
        return pro.toString();
    }

    public String print(){
        return "cart number = " + cartNumber + ", date = " + date.toString() + ", Products Detail = " + '\'' + calculateTotalPrice();
    }
}
