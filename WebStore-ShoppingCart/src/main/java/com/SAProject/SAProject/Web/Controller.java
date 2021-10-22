package com.SAProject.SAProject.Web;

import com.SAProject.SAProject.Service.ShoppingCartService;
import com.SAProject.SAProject.Service.ProductDTO;
import com.SAProject.SAProject.Service.ShoppingCartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingCart")
public class Controller {
    @Autowired
    private ShoppingCartService shoppingCartService;

    @PostMapping("/createCart")
    public ResponseEntity<ShoppingCartDTO> createShoppingCart() {
        return new  ResponseEntity<ShoppingCartDTO>(shoppingCartService.createCart(), HttpStatus.OK);
    }

    @PostMapping("/addProduct/{cartId}")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO, @PathVariable String cartId){
        return new ResponseEntity<ShoppingCartDTO>(shoppingCartService.addProduct(cartId, productDTO), HttpStatus.NO_CONTENT);
    }

    @PostMapping("/removeProduct/{cartId}")
    public ResponseEntity<?> deleteProduct(@RequestBody ProductDTO productDTO, @PathVariable String cartId){
       return new ResponseEntity<ShoppingCartDTO>(shoppingCartService.removeProduct(cartId,productDTO), HttpStatus.NO_CONTENT);
    }

    @PostMapping("/changeQuantity/{cartId}/{productId}/{quantity}")
    public ResponseEntity<?> changeQuantity(@PathVariable String cartId, @PathVariable String productId, @PathVariable int quantity) throws InterruptedException {
        return new ResponseEntity<ShoppingCartDTO>(shoppingCartService.changeProductQuantity(cartId,productId,quantity), HttpStatus.OK);
    }

    @PostMapping("/checkOut/{cartId}/{customerId}")
    public ResponseEntity<?> checkOut(@PathVariable String cartId, @PathVariable String customerId){
        return new ResponseEntity<ShoppingCartDTO>(shoppingCartService.checkOut(cartId, customerId), HttpStatus.OK);
    }
}
