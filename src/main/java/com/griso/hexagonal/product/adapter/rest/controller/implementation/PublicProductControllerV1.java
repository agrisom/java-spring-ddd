package com.griso.hexagonal.product.adapter.rest.controller.implementation;

import com.griso.hexagonal.product.adapter.repository.ProductRepositoryMongoDb;
import com.griso.hexagonal.product.adapter.rest.controller.definition.PublicProductController;
import com.griso.hexagonal.product.application.service.definition.ProductService;
import com.griso.hexagonal.product.application.service.implementation.ProductServiceImpl;
import com.griso.hexagonal.product.domain.model.Product;
import io.swagger.annotations.Api;
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
@RequestMapping("/v1/public/product")
@Api(tags = "Public product APIs")
public class PublicProductControllerV1 implements PublicProductController {

    ProductService productService;

    @Autowired
    ProductRepositoryMongoDb productRepository;

    @Override
    public Page<Product> getProducts(Integer page, Integer size, String sortBy, String sortDir) {
        productService = new ProductServiceImpl(productRepository);
        return productService.getAll(PageRequest.of(page, size,
                Sort.by(Sort.Direction.fromString(sortDir), sortBy)));
    }

    @Override
    public List<Product> getAllProducts() {
        productService = new ProductServiceImpl(productRepository);
        return productService.getAll();
    }

    @Override
    public Product findById(String id) {
        productService = new ProductServiceImpl(productRepository);
        return productService.findById(id);
    }

    @Override
    public Product save(Product product) {
        productService = new ProductServiceImpl(productRepository);
        return productService.save(product);
    }

    @Override
    public Product update(Product product) {
        productService = new ProductServiceImpl(productRepository);
        return productService.save(product);
    }

    @Override
    public void delete(String id) {
        productService = new ProductServiceImpl(productRepository);
        productService.delete(id);
    }
}
