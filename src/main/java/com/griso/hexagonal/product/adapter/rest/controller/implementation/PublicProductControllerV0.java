package com.griso.hexagonal.product.adapter.rest.controller.implementation;

import com.griso.hexagonal.product.adapter.repository.ProductRepositoryMock;
import com.griso.hexagonal.product.adapter.rest.controller.definition.IPublicProductController;
import com.griso.hexagonal.product.application.service.definition.IProductService;
import com.griso.hexagonal.product.application.service.implementation.ProductService;
import com.griso.hexagonal.product.domain.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
@RequestMapping("/v0/public/product")
public class PublicProductControllerV0 implements IPublicProductController {

    @Autowired
    ProductRepositoryMock productRepository;

    IProductService productService;

    @Override
    public Page<Product> getProducts(Integer page, Integer size, String sortBy, String sortDir) {
        productService = new ProductService(productRepository);
        return productService.getAll(PageRequest.of(page, size,
                Sort.by(Sort.Direction.fromString(sortDir), sortBy)));
    }

    @Override
    public List<Product> getAllProducts() {
        productService = new ProductService(productRepository);
        return productService.getAll();
    }

    @Override
    public Product findById(String id) {
        productService = new ProductService(productRepository);
        return productService.findById(id);
    }

    @Override
    public Product save(Product product) {
        productService = new ProductService(productRepository);
        return productService.save(product);
    }

    @Override
    public Product update(Product product) {
        productService = new ProductService(productRepository);
        return productService.update(product);
    }

    @Override
    public void delete(String id) {
        productService = new ProductService(productRepository);
        productService.delete(id);
    }
}
