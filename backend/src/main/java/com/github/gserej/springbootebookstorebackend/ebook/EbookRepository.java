package com.github.gserej.springbootebookstorebackend.ebook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EbookRepository extends JpaRepository<Ebook, Long> {
    List<Ebook> getEbookByCategoriesIs(Long id);
}
