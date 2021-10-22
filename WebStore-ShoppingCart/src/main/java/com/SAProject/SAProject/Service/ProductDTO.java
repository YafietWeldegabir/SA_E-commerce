package com.SAProject.SAProject.Service;

import lombok.*;

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
