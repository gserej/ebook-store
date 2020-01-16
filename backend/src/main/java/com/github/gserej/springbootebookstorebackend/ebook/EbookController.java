package com.github.gserej.springbootebookstorebackend.ebook;


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

    @GetMapping("/ebooks")
    public List<EbookDto> getAllEbooks() {
        return ebookService.getAllEbooks();
    }

    @GetMapping("/category/{id}")
    public List<EbookDto> getEbooksByCategory(@PathVariable(value = "id") Long categoryId) {
        return ebookService.getEbooksByCategory(categoryId);
    }

    @GetMapping("/ebooks/{id}")
    public EbookDto getEbookById(@PathVariable(value = "id") Long ebookId) throws EbookNotFoundException {
        return ebookService.getEbookById(ebookId);
    }


    //    @PreAuthorize("hasAuthority('MODERATOR')")
    @PostMapping("/ebooks")
    public EbookDto createEbook(@Valid @RequestBody Ebook ebook) {
        return ebookService.createEbook(ebook);
    }

    //    @PreAuthorize("hasAuthority('MODERATOR')")
    @PutMapping("/ebooks/{id}")
    public EbookDto updateEbook(@PathVariable(value = "id") Long ebookId,
                                @Valid @RequestBody Ebook ebookDetails) throws EbookNotFoundException {
        return ebookService.updateEbook(ebookId, ebookDetails);
    }

//    @PreAuthorize("hasAuthority('MODERATOR')")

    @DeleteMapping("/ebooks/{id}")
    public void deleteEbook(@PathVariable(value = "id") Long ebookId) throws EbookNotFoundException {
        ebookService.deleteEbook(ebookId);

    }
}
