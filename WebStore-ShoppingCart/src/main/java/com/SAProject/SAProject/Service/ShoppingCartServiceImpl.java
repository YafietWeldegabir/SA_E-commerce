package com.SAProject.SAProject.Service;

import com.SAProject.SAProject.Domain.ShoppingCart;
import com.SAProject.SAProject.Domain.ShoppingCartServiceDomain;
import com.SAProject.SAProject.Repository.ShoppingCartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

    @Autowired
    private ShoppingCartRepo shoppingCartRepo;
    @Autowired
    private ShoppingCartChangeSender shoppingCartChangeSender;
//    @Autowired
//    private ProductQuantitySender productQuantitySender;
//    @Autowired
//    private ProductQuantityRequestListener productQuantityRequestListener;
    @Autowired
    productFeignClient productFeignClient;


    @Override
    public ShoppingCartDTO createCart() {
        ShoppingCartServiceDomain domain = new ShoppingCartServiceDomain();
        ShoppingCart shoppingCart = domain.createShoppingCart();
        shoppingCartRepo.save(shoppingCart);
        ShoppingCartChangeEventDTO shoppingCartChangeEventDTO = new ShoppingCartChangeEventDTO("create Cart", null,shoppingCart.getCartNumber());
        shoppingCartChangeSender.send(shoppingCartChangeEventDTO);
        ShoppingCartAdaptor adaptor = new ShoppingCartAdaptor();
        ShoppingCartDTO cart = adaptor.toShoppingCartDTO(shoppingCart);
        return cart;
    }

    @Override
    public ShoppingCartDTO addProduct(String id, ProductDTO productDTO) {
        ShoppingCartServiceDomain domain = new ShoppingCartServiceDomain();
        ProductAdaptor productAdaptor = new ProductAdaptor();
        Optional<ShoppingCart> shoppingCart = shoppingCartRepo.findById(id);
        if(shoppingCart.isPresent()){
            shoppingCart = Optional.ofNullable(domain.addProduct(shoppingCart.get(), productAdaptor.toProduct(productDTO)));
//            shoppingCart = domain.addProduct(shoppingCart.get(), productAdaptor.toProduct(productDTO)) ;

            shoppingCartRepo.save(shoppingCart.get());
            ShoppingCartChangeEventDTO shoppingCartChangeEventDTO = new ShoppingCartChangeEventDTO("add product", productDTO,id);
            shoppingCartChangeSender.send(shoppingCartChangeEventDTO);
            ShoppingCartAdaptor adaptor = new ShoppingCartAdaptor();
            ShoppingCartDTO cart = adaptor.toShoppingCartDTO(shoppingCart.get());
            return cart;
        }else {
            ShoppingCartDTO shoppingCart1 = createCart();
            return addProduct(shoppingCart1.getCartNumber(),productDTO);
        }
    }

    @Override
    public ShoppingCartDTO removeProduct(String id, ProductDTO productDTO) {
        ShoppingCartServiceDomain domain = new ShoppingCartServiceDomain();
        ProductAdaptor productAdaptor = new ProductAdaptor();
        Optional<ShoppingCart> shoppingCart = shoppingCartRepo.findById(id);
        if(shoppingCart.isPresent()){
            shoppingCart = Optional.ofNullable(domain.removeProduct(shoppingCart.get(), productAdaptor.toProduct(productDTO)));
            shoppingCartRepo.save(shoppingCart.get());
            ShoppingCartChangeEventDTO shoppingCartChangeEventDTO = new ShoppingCartChangeEventDTO("remove product", productDTO,id);
            shoppingCartChangeSender.send(shoppingCartChangeEventDTO);
            ShoppingCartAdaptor adaptor = new ShoppingCartAdaptor();
            ShoppingCartDTO cart = adaptor.toShoppingCartDTO(shoppingCart.get());
            return cart;
        }
        return null;
    }


    // need to check the product service if they have enough quantity
    @Override
    public ShoppingCartDTO changeProductQuantity(String cartId, String productId, int quantity) throws InterruptedException {
        ShoppingCartServiceDomain domain = new ShoppingCartServiceDomain();
        ProductAdaptor productAdaptor = new ProductAdaptor();
        Optional<ShoppingCart> shoppingCart = shoppingCartRepo.findById(cartId);
        if(shoppingCart.isPresent()){

            // need to call over feign or kafka to check if we have enough quantity of the product

//            productQuantitySender.send(productId);
//            Thread.sleep(5000);
//            System.out.println(productQuantityRequestListener.getAmount());
            int amount = productFeignClient.getQuantity(productId);
            if(amount > quantity){
                shoppingCart = Optional.ofNullable(domain.changeQuantity(shoppingCart.get(),productId,quantity));
                shoppingCartRepo.save(shoppingCart.get());
                ProductDTO productDTO = productAdaptor.toProductDTO(domain.getProduct(shoppingCart.get(), productId));
                ShoppingCartChangeEventDTO shoppingCartChangeEventDTO = new ShoppingCartChangeEventDTO("change quantity", productDTO,cartId);
                shoppingCartChangeSender.send(shoppingCartChangeEventDTO);
                ShoppingCartAdaptor adaptor = new ShoppingCartAdaptor();
                ShoppingCartDTO cart = adaptor.toShoppingCartDTO(shoppingCart.get());
                return cart;
            }

        }
        return null;
    }

    @Override
    public ShoppingCartDTO checkOut(String cartId, String customerId) {
        System.out.println("getting ready for checkout");
        Optional<ShoppingCart> shoppingCart = shoppingCartRepo.findById(cartId);
        if(shoppingCart.isPresent()){
            ShoppingCartAdaptor adaptor = new ShoppingCartAdaptor();
            ShoppingCartDTO cart = adaptor.toShoppingCartDTO(shoppingCart.get());
            ShoppingCartCheckOut shoppingCartCheckOut = new ShoppingCartCheckOut(customerId, cart);
            System.out.println("about to send to check out");
            shoppingCartChangeSender.checkOut(shoppingCartCheckOut);
        }
        return null;
    }

    @FeignClient(name = "product-service", url = "http://localhost:8081")
    interface productFeignClient{
        @RequestMapping("/product/getQuantity/{id}")
        public Integer getQuantity(@PathVariable("id") String id);
    }

}
