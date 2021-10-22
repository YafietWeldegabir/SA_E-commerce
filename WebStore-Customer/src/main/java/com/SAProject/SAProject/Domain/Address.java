package com.SAProject.SAProject.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Address {
    private String street;
    private String city;
    private String state;
    private String country;
    private int zip;
}
