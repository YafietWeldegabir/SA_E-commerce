package com.SAProject.SAProject.Service;

import com.SAProject.SAProject.Domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ShoppingCartDTO {
    private String cartNumber;
    private LocalDate date;
    private List<Product> products = new ArrayList<>();
}
