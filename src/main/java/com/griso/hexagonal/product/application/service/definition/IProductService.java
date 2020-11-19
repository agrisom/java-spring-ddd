package com.griso.hexagonal.product.application.service.definition;

import com.griso.hexagonal.product.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {

    Page<Product> getAll(Pageable pageable);
    List<Product> getAll();
    Product findById(String id);
    Product save(Product product);
    Product update(Product product);
    void delete(String id);

}
