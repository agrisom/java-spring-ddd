package com.griso.hexagonal.product.adapter.rest.controller.definition;

import com.griso.hexagonal.product.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IPublicProductController {

    @GetMapping
    Page<Product> getProducts(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "id") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") String sortDir);

    @GetMapping("/all")
    List<Product> getAllProducts();

    @GetMapping("/{id}")
    Product findById(@PathVariable(required = true) String id);

    @PostMapping
    Product save(Product product);

    @PatchMapping
    Product update(Product product);

    @DeleteMapping("/{id}")
    void delete(@PathVariable(required = true) String id);

}
