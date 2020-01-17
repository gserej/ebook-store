package com.github.gserej.springbootebookstorebackend.ebook;

import com.github.gserej.springbootebookstorebackend.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EbookRepository extends JpaRepository<Ebook, Long> {
    List<Ebook> findAllByCategories(Category category);

    Optional<Ebook> findFirstByShortName(String shortName);

}
