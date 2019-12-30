package com.github.gserej.springbootebookstorebackend.category;


import com.github.gserej.springbootebookstorebackend.ebook.EbookNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {


    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toCategoryDto)
                .collect(Collectors.toList());

    }

    public CategoryDto getCategoryById(Long id) throws EbookNotFoundException {
        Category category = categoryRepository.findById(id).orElseThrow(EbookNotFoundException::new);

        return categoryMapper.toCategoryDto(category);
    }
}
