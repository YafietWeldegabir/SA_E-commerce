package com.SAProject.SAProject.Service;


import com.SAProject.SAProject.Domain.Customer;

public class CustomerAdaptor {

    public static Customer toCustomer(CustomerDTO customerDTO){
        return new Customer();
    }

    public static CustomerDTO toCustomerDTO(Customer customer){
        return new CustomerDTO(customer.getDrivingLicenseId(),customer.getFirstName(),customer.getLastName(),customer.getAddress().toString(),customer.getContact().getEmail());
    }
}
