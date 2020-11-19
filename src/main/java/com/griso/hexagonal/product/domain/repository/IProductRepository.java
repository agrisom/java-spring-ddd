package com.griso.hexagonal.product.domain.repository;

import com.griso.hexagonal.product.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IProductRepository {
    <S extends Product> S save(S s);

    Optional<Product> findById(String s);

    List<Product> findAll();

    Page<Product> findAll(Pageable pageable);

    void deleteById(String s);
}
