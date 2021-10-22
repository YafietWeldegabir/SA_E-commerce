package com.SAProject.SAProject.Service;

import com.SAProject.SAProject.Domain.IdGenerator;
import com.SAProject.SAProject.Domain.Order;
import com.SAProject.SAProject.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private customerFeignClient customerFeignClient;
    @Autowired
    private RemoteReceiver customerReceiver;
    @Autowired
    private OrderRepo orderRepo;

    public void placeOrder(ShoppingCartCheckOut shoppingCartCheckOut){
        CustomerDTO customerDTO = customerFeignClient.getCustomer(shoppingCartCheckOut.getCustomerId());

        IdGenerator idGenerator = new IdGenerator();
        CustomerAdaptor customerAdaptor = new CustomerAdaptor();
        ShoppingCartAdaptor shoppingCartAdaptor = new ShoppingCartAdaptor();

        Order order = new Order(idGenerator.generate(),customerAdaptor.toCustomer(customerDTO), shoppingCartAdaptor.toShoppingCart(shoppingCartCheckOut.getShoppingCartDTO()));
        orderRepo.save(order);
        System.out.println("printing order from order service");
        System.out.println(order.printOrder());
    }


    public Order getOrder(String orderId){
        return orderRepo.findById(orderId).orElse(null);
    }

    @Override
    public List<Order> getOrder() {
        return orderRepo.findAll();
    }

    @FeignClient(name = "customer-service", url = "http://localhost:8080")
    interface customerFeignClient{
        @RequestMapping("/customer/get/{id}")
        public CustomerDTO getCustomer(@PathVariable("id") String id);
    }


}
