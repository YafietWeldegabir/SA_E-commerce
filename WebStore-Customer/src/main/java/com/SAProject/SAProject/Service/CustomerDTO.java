package com.SAProject.SAProject.Service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CustomerDTO {
    private String drivingLicenseId;    // This is what makes one Customer unique from another
    private String  firstName;
    private String lastName;
    private String address;
    private String email;
}
