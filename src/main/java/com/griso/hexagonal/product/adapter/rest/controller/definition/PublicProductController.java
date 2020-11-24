package com.griso.hexagonal.product.adapter.rest.controller.definition;

import com.griso.hexagonal.product.adapter.dto.ProductDto;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface PublicProductController {

    @GetMapping
    Page<ProductDto> getProducts(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "id") String sortBy,
            @RequestParam(required = false, defaultValue = "ASC") String sortDir);

    @GetMapping("/all")
    List<ProductDto> getAllProducts();

    @GetMapping("/{id}")
    ProductDto findById(@PathVariable(required = true) String id);

    @PostMapping
    ProductDto save(@RequestBody ProductDto product);

    @PatchMapping
    ProductDto update(@RequestBody ProductDto product);

    @DeleteMapping("/{id}")
    void delete(@PathVariable(required = true) String id);

}
