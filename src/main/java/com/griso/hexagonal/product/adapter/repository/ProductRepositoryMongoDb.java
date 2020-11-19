package com.griso.hexagonal.product.adapter.repository;

import com.griso.hexagonal.product.domain.model.Product;
import com.griso.hexagonal.product.domain.repository.ProductRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryMongoDb extends ProductRepository, MongoRepository<Product, String> {

}
