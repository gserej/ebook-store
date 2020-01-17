package com.github.gserej.springbootebookstorebackend.ebook;


import com.github.gserej.springbootebookstorebackend.category.CategoryNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public List<EbookDto> getAllEbooks() {
        return ebookService.getAllEbooks();
    }

    @GetMapping(value = "/ebooks", params = "categoryShortName")
    public List<EbookDto> getEbooksByCategory(@RequestParam(value = "categoryShortName") String categoryShortName) throws CategoryNotFoundException {
        return ebookService.getEbooksByCategory(categoryShortName);
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
