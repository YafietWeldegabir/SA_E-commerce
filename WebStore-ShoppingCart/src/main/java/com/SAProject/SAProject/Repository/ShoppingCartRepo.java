package com.SAProject.SAProject.Repository;

import com.SAProject.SAProject.Domain.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepo extends MongoRepository<ShoppingCart,String> {
}
