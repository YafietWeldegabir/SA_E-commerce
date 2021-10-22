package com.SAProject.SAProject.Service;

import com.SAProject.SAProject.Domain.Customer;

public interface CustomerService {
    Customer addCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    CustomerDTO getCustomer(String id);
    Customer deleteCustomer(String id);

}
