package ru.geekbrains.SpringContinue.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ru.geekbrains.SpringContinue.dto.ProductDto;
import ru.geekbrains.SpringContinue.entity.Product;

@Mapper
public interface ProductDtoMapper {

    ProductDtoMapper MAPPER = Mappers.getMapper(ProductDtoMapper.class);

    @Mapping(target = "title", source = "productDto.title")
    Product toProduct(ProductDto productDto);
}
