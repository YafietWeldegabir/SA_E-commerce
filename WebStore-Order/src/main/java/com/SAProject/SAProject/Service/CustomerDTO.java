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
    private String drivingLicenseId;    // to make it unique for every customer identification
    private String  firstName;
    private String lastName;
    private String address;
    private String email;
}
