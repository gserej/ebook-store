package com.github.gserej.springbootebookstorebackend.controller;


import com.github.gserej.springbootebookstorebackend.exception.ResourceNotFoundException;
import com.github.gserej.springbootebookstorebackend.model.Ebook;
import com.github.gserej.springbootebookstorebackend.repository.EbookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
class EbookController {

    private EbookRepository repository;

    public EbookController(EbookRepository repository) {
        this.repository = repository;

    }

    @GetMapping("/ebooks")
    public List<Ebook> getAllEbooks() {
        return repository.findAll();
    }

    @GetMapping("/ebooks/{id}")
    public Ebook getEbookById(@PathVariable(value = "id") Long ebookId)
            throws ResourceNotFoundException {
        return repository.findById(ebookId)
                .orElseThrow(() -> new ResourceNotFoundException("Ebook not found for this id : " + ebookId));
    }

    @PostMapping("/ebooks")
    public Ebook createEbook(@Valid @RequestBody Ebook ebook) {
        return repository.save(ebook);
    }

    @PutMapping("/ebooks/{id}")
    public ResponseEntity<Ebook> updateEbook(@PathVariable(value = "id") Long ebookId,
                                             @Valid @RequestBody Ebook ebookDetails) throws ResourceNotFoundException {
        Ebook ebook = repository.findById(ebookId)
                .orElseThrow(() -> new ResourceNotFoundException("Ebook not found for this id : " + ebookId));

        ebook.setTitle(ebookDetails.getTitle());
        ebook.setAuthor(ebookDetails.getAuthor());
        ebook.setPages(ebookDetails.getPages());
        ebook.setDescription(ebookDetails.getDescription());
        ebook.setLanguage(ebookDetails.getLanguage());
        ebook.setImageUrl(ebookDetails.getImageUrl());
        ebook.setPublicationYear(ebookDetails.getPublicationYear());
        ebook.setDate(ebookDetails.getDate());
        ebook.setFormat(ebookDetails.getFormat());
        ebook.setKey(ebookDetails.getKey());


        final Ebook updatedEbook = repository.save(ebook);
        return ResponseEntity.ok(updatedEbook);
    }

    @DeleteMapping("/ebooks/{id}")
    public Map<String, Boolean> deleteEbook(@PathVariable(value = "id") Long ebookId)
            throws ResourceNotFoundException {
        Ebook ebook = repository.findById(ebookId)
                .orElseThrow(() -> new ResourceNotFoundException("Ebook not found for this id : " + ebookId));

        repository.delete(ebook);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
