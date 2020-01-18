package com.github.gserej.springbootebookstorebackend.ebook;


import com.github.gserej.springbootebookstorebackend.category.CategoryNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/")
class EbookController {

    private EbookService ebookService;

    @Autowired
    EbookController(EbookService ebookService) {
        this.ebookService = ebookService;
    }


    @GetMapping(value = "/ebooks")
    public Page<EbookDto> getEbooks(Pageable pageable) {
        return ebookService.getEbooksByPage(pageable);
    }

    @GetMapping(value = "/ebooks", params = "categoryShortName")
    public Page<EbookDto> getEbooksByCategory(@RequestParam(value = "categoryShortName") String categoryShortName,
                                              Pageable pageable) throws CategoryNotFoundException {
        return ebookService.getEbooksByCategory(categoryShortName, pageable);
    }

    @GetMapping("/ebooks/{id}")
    public EbookDto getEbookById(@PathVariable(value = "id") Long ebookId) throws EbookNotFoundException {
        return ebookService.getEbookById(ebookId);
    }

    @GetMapping("/ebooks/name/{id}")
    public EbookDto getEbookByShortName(@PathVariable(value = "id") String ebookShortName) throws EbookNotFoundException {
        return ebookService.getEbookByShortName(ebookShortName);
    }

    @PostMapping("/ebooks")
    public EbookDto createEbook(@Valid @RequestBody Ebook ebook) {
        return ebookService.createEbook(ebook);
    }

    @PutMapping("/ebooks/{id}")
    public EbookDto updateEbook(@PathVariable(value = "id") Long ebookId,
                                @Valid @RequestBody Ebook ebookDetails) throws EbookNotFoundException {
        return ebookService.updateEbook(ebookId, ebookDetails);
    }

    @DeleteMapping("/ebooks/{id}")
    public void deleteEbook(@PathVariable(value = "id") Long ebookId) throws EbookNotFoundException {
        ebookService.deleteEbook(ebookId);
    }
}
