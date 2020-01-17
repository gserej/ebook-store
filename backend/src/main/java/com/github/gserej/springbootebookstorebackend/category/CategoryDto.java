package com.github.gserej.springbootebookstorebackend.category;

import lombok.Data;

@Data
public class CategoryDto {

    private Long id;
    private String fullName;
    private String shortName;

}
