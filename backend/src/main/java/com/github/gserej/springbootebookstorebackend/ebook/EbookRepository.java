package com.github.gserej.springbootebookstorebackend.ebook;

import com.github.gserej.springbootebookstorebackend.category.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EbookRepository extends JpaRepository<Ebook, Long> {

    Page<Ebook> findAllByCategories(Category category, Pageable pageable);

    Optional<Ebook> findFirstByShortName(String shortName);



}
