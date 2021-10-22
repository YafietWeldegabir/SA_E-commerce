package com.SAProject.SAProject.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String productNumber;
    private String name;
    private double price;
    private String description;
    private int quantity;
}
