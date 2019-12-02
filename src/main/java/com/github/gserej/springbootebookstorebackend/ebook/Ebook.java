package com.github.gserej.springbootebookstorebackend.ebook;


import com.github.gserej.springbootebookstorebackend.category.Category;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity(name = "ebooks")
public class Ebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "title")
    private String title;


    @Column(name = "dateAdded")
    private LocalDateTime dateAdded;

    @Column(name = "description")
    private String description;

    @Column(name = "imageUrl")
    private String imageUrl;

    @Column(name = "author")
    private String author;

    @Column(name = "publicationYear")
    private int publicationYear;

    @Column(name = "pages")
    private int pages;

    @Column(name = "language")
    private String language;

    @Column(name = "isbn")
    private String isbn;

    @Enumerated(EnumType.STRING)
    private Format format;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ebook_category",
            joinColumns = @JoinColumn(name = "ebook_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories;

}
