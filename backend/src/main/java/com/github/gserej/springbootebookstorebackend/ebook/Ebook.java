package com.github.gserej.springbootebookstorebackend.ebook;


import com.github.gserej.springbootebookstorebackend.category.Category;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@Entity(name = "ebooks")
public class Ebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "shortname")
    private String shortName;

    @NonNull
    @Column(name = "title")
    private String title;

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
    private EbookFormat ebookFormat;

    @Column(name = "dateAdded")
    private LocalDateTime dateAdded;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "ebook_category",
            joinColumns = @JoinColumn(name = "ebook_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Set<Category> categories = new HashSet<>();

    public void addCategory(Category category) {
        categories.add(category);
        category.getEbooks().add(this);
    }
}
