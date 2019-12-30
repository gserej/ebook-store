package com.github.gserej.springbootebookstorebackend.category;


import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    CategoryDto toCategoryDto(Category category);

}
