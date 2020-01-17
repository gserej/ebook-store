package com.github.gserej.springbootebookstorebackend.ebook;

import com.github.gserej.springbootebookstorebackend.category.Category;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Data
public class EbookDto {

    private Long id;
    private String shortName;
    private String title;
    private LocalDateTime dateAdded;
    private String description;
    private String imageUrl;
    private String author;
    private int publicationYear;
    private int pages;
    private String language;
    private String isbn;

    private EbookFormat ebookFormat;

    private Set<Category> categories;
}
