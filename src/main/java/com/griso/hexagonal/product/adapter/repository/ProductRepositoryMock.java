package com.griso.hexagonal.product.adapter.repository;

import com.griso.hexagonal.product.domain.model.Product;
import com.griso.hexagonal.product.domain.repository.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class ProductRepositoryMock implements ProductRepository {

    @Override
    public <S extends Product> S save(S s) {
        return null;
    }

    @Override
    public Optional<Product> findById(String s) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        Product product = new Product();
        product.setId("ajhdsfal2knp23453");
        product.setName("Test product");
        product.setDescription("Mocked product");
        product.setPrice(14);

        return Arrays.asList(product);
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void deleteById(String s) {

    }
}
