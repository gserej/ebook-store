package com.github.gserej.springbootebookstorebackend.category;


import com.github.gserej.springbootebookstorebackend.ebook.Ebook;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "fullname")
    private String fullName;

    @NonNull
    @Column(name = "shortname")
    private String shortName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ebook_category",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "ebook_id")
    )
    private Set<Ebook> ebook = new HashSet<>();

    public Category(String fullName, String shortName) {
        this.fullName = fullName;
        this.shortName = shortName;
    }

}
