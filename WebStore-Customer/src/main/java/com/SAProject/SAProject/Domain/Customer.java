package com.SAProject.SAProject.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    private String drivingLicenseId;    // to make it unique for every customer identification
    private String  firstName;
    private String lastName;
    private Address address;
    private Contact contact;
}
