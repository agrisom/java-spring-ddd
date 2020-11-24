package com.griso.hexagonal.product.adapter.rest.controller.implementation;

import com.griso.hexagonal.product.adapter.dto.ProductDto;
import com.griso.hexagonal.product.adapter.mapper.ProductMapper;
import com.griso.hexagonal.product.adapter.repository.ProductRepositoryMongoDb;
import com.griso.hexagonal.product.adapter.rest.controller.definition.PublicProductController;
import com.griso.hexagonal.product.application.service.definition.ProductService;
import com.griso.hexagonal.product.application.service.implementation.ProductServiceImpl;
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
    ProductMapper productMapper;

    @Autowired
    ProductRepositoryMongoDb productRepository;

    @Override
    public Page<ProductDto> getProducts(Integer page, Integer size, String sortBy, String sortDir) {
        productService = new ProductServiceImpl(productRepository);
        return productService.getAll(PageRequest.of(page, size,
                Sort.by(Sort.Direction.fromString(sortDir), sortBy))).map(productMapper::toProductView);
    }

    @Override
    public List<ProductDto> getAllProducts() {
        productService = new ProductServiceImpl(productRepository);
        return productMapper.toProductViewList(productService.getAll());
    }

    @Override
    public ProductDto findById(String id) {
        productService = new ProductServiceImpl(productRepository);
        return productMapper.toProductView(productService.findById(id));
    }

    @Override
    public ProductDto save(ProductDto product) {
        productService = new ProductServiceImpl(productRepository);
        return productMapper.toProductView(productService.save(productMapper.toProductModel(product)));
    }

    @Override
    public ProductDto update(ProductDto product) {
        productService = new ProductServiceImpl(productRepository);
        return productMapper.toProductView(productService.save(productMapper.toProductModel(product)));
    }

    @Override
    public void delete(String id) {
        productService = new ProductServiceImpl(productRepository);
        productService.delete(id);
    }
}
