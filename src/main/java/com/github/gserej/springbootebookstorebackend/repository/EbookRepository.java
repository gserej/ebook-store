package com.github.gserej.springbootebookstorebackend.repository;

import com.github.gserej.springbootebookstorebackend.model.Ebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EbookRepository extends JpaRepository<Ebook, Long> {
}
