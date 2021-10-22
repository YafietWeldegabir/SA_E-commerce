package com.SAProject.SAProject.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class ShoppingCartChangeEventDTO {
    private String change;
    private ProductDTO productDTO;
    private String cartId;
}
