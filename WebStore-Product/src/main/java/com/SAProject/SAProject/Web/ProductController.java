package com.SAProject.SAProject.Web;

import com.SAProject.SAProject.Service.ProductDTO;
import com.SAProject.SAProject.Service.ProductService;
import com.SAProject.SAProject.Domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product product1 = productService.addProduct(product);
        return new  ResponseEntity<Product>(product1, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        Product product1 = productService.updateProduct(product);
        if(product1 != null) return new ResponseEntity<Product>(product1,HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id){
        Product product = productService.deleteProduct(id);
        if(product != null) return new ResponseEntity<Product>(product, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> getProduct(@PathVariable String id){
        ProductDTO product = productService.getProduct(id);
        if(product != null) return new ResponseEntity<ProductDTO>(product, HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }
    @GetMapping("/getQuantity/{id}")
    public ResponseEntity<?> getQuantity(@PathVariable String id){
        ProductDTO product = productService.getProduct(id);
        return new ResponseEntity<Integer>(product.getQuantity(),HttpStatus.OK);
    }

}
