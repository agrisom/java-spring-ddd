package com.griso.hexagonal.product.adapter.mapper;

import com.griso.hexagonal.product.adapter.dto.ProductDto;
import com.griso.hexagonal.product.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {

    Product toProductModel(ProductDto product);
    ProductDto toProductView(Product product);
    List<Product> toProductModelList(List<ProductDto> product);
    List<ProductDto> toProductViewList(List<Product> product);

}
