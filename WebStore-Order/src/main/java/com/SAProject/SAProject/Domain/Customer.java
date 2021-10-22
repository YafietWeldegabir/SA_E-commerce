package com.SAProject.SAProject.Domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
public class Customer {
    private String drivingLicenseId;    // to make it unique for every customer identification
    private String  firstName;
    private String lastName;
    private String address;
    private String email;
}
