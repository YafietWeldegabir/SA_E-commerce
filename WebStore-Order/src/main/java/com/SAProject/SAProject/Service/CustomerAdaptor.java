package com.SAProject.SAProject.Service;

import com.SAProject.SAProject.Domain.Customer;

public class CustomerAdaptor {

    public Customer toCustomer(CustomerDTO customerDTO){
        return new Customer(customerDTO.getDrivingLicenseId(),customerDTO.getFirstName(),customerDTO.getLastName(),customerDTO.getAddress(),customerDTO.getEmail());
    }

    public CustomerDTO toCustomerDTO(Customer customer){
        return new CustomerDTO(customer.getDrivingLicenseId(),customer.getFirstName(),customer.getLastName(),customer.getAddress(),customer.getEmail());
    }
}
