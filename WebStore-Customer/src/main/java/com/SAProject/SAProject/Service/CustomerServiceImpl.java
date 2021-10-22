package com.SAProject.SAProject.Service;

import com.SAProject.SAProject.Domain.Customer;
import com.SAProject.SAProject.Domain.Address;
import com.SAProject.SAProject.Domain.Contact;
import com.SAProject.SAProject.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;


    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Optional<Customer> customer2 = customerRepo.findById(customer.getDrivingLicenseId());
        if(customer2.isPresent()){
            Customer customer1 = customer2.get();
            if(!customer1.getFirstName().equalsIgnoreCase(customer.getFirstName())) customer1.setFirstName(customer.getFirstName());
            if(!customer1.getLastName().equalsIgnoreCase(customer.getLastName())) customer1.setLastName(customer.getLastName());
            if(!customer1.getContact().getEmail().equalsIgnoreCase(customer.getContact().getEmail()) ||
               !customer1.getContact().getPhoneNumber().equalsIgnoreCase(customer.getContact().getPhoneNumber())){
                Contact contact = new Contact(customer.getContact().getEmail(), customer.getContact().getPhoneNumber());
                customer1.setContact(contact);
            }
            if(!customer1.getAddress().getStreet().equalsIgnoreCase(customer.getAddress().getStreet()) ||
               !customer1.getAddress().getCity().equalsIgnoreCase(customer.getAddress().getCity()) ||
                    !customer1.getAddress().getState().equalsIgnoreCase(customer.getAddress().getState()) ||
                    !customer1.getAddress().getCountry().equalsIgnoreCase(customer.getAddress().getCountry()) ||
                    (customer1.getAddress().getZip() != customer.getAddress().getZip())){
                Address address = new Address(customer.getAddress().getStreet(),customer.getAddress().getCity(),customer.getAddress().getState()
                                              ,customer.getAddress().getCountry(),customer.getAddress().getZip());
                customer1.setAddress(address);
            }
            customerRepo.deleteById(customer1.getDrivingLicenseId());
            customerRepo.save(customer1);
            return customer1;
        }
        return null;
    }

    @Override
    public CustomerDTO getCustomer(String id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if(customer.isPresent()) return CustomerAdaptor.toCustomerDTO(customer.get());
        return null;
    }

    @Override
    public Customer deleteCustomer(String id) {
        Optional<Customer> customer = customerRepo.findById(id);
        if(customer.isPresent()){
            customerRepo.deleteById(id);
            return customer.get();
        } else return null;
    }
}
