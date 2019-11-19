package com.github.gserej.springbootebookstorebackend.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Ebook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String title;
    private String key;
    private LocalDateTime date;
    private String description;
    private String imageUrl;
    private String author;
    private int publicationYear;
    private int pages;
    private String language;
    private String format;





}
