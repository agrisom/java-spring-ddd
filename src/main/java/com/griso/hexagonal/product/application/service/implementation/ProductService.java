package com.griso.hexagonal.product.application.service.implementation;

import com.griso.hexagonal.product.application.service.definition.IProductService;
import com.griso.hexagonal.product.domain.model.Product;
import com.griso.hexagonal.product.domain.repository.IProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private final IProductRepository productRepo;

    public ProductService(IProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Page<Product> getAll(Pageable pageable) {
        return productRepo.findAll(pageable);
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product findById(String id) {
        return productRepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product id: " + id + " Not Found"));
    }

    @Override
    public Product save(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void delete(String id) {
        productRepo.deleteById(id);
    }
}
