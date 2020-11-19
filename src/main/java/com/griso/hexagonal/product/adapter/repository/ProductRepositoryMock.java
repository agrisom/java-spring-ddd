package com.griso.hexagonal.product.adapter.repository;

import com.griso.hexagonal.product.domain.model.Product;
import com.griso.hexagonal.product.domain.repository.IProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryMock implements IProductRepository {

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
        return null;
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public void deleteById(String s) {

    }
}
