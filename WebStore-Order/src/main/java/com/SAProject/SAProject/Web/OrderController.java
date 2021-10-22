package com.SAProject.SAProject.Web;

import com.SAProject.SAProject.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getorder/{orderId}")
    public ResponseEntity<?> getOrder(@PathVariable String orderId){
        System.out.println("inside get order");
        return new ResponseEntity<>(orderService.getOrder(orderId), HttpStatus.OK);
    }

    @GetMapping("/getorder")
    public ResponseEntity<?> getAllOrder(){
        System.out.println("inside get all order");
        return new ResponseEntity<>(orderService.getOrder(), HttpStatus.OK);
    }
}
