package com.SAProject.SAProject.Web;

import com.SAProject.SAProject.Domain.Customer;
import com.SAProject.SAProject.Service.CustomerDTO;
import com.SAProject.SAProject.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer customer1 = customerService.addCustomer(customer);
        return new  ResponseEntity<Customer>(customer1, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
        Customer customer1 = customerService.updateCustomer(customer);
        if(customer1 != null) return new ResponseEntity<Customer>(customer1,HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id){
        Customer customer1 = customerService.deleteCustomer(id);
        if(customer1 != null) return new ResponseEntity<Customer>(customer1, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable String id){
        CustomerDTO customer1 = customerService.getCustomer(id);
        if(customer1 != null) return new ResponseEntity<CustomerDTO>(customer1, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
}
