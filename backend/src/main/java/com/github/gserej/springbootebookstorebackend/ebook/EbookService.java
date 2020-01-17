package com.github.gserej.springbootebookstorebackend.ebook;


import com.github.gserej.springbootebookstorebackend.category.Category;
import com.github.gserej.springbootebookstorebackend.category.CategoryNotFoundException;
import com.github.gserej.springbootebookstorebackend.category.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EbookService {

    private final EbookRepository ebookRepository;
    private final CategoryRepository categoryRepository;
    private final EbookMapper ebookMapper;


    public EbookService(EbookRepository ebookRepository, CategoryRepository categoryRepository, EbookMapper ebookMapper) {
        this.ebookRepository = ebookRepository;
        this.categoryRepository = categoryRepository;
        this.ebookMapper = ebookMapper;
    }

    public List<EbookDto> getAllEbooks() {
        return ebookRepository.findAll()
                .stream()
                .map(ebookMapper::toEbookDto)
                .collect(Collectors.toList());

    }

    public List<EbookDto> getEbooksByCategory(String categoryShortName) throws CategoryNotFoundException {
        Category category = categoryRepository.findByShortName(categoryShortName).orElseThrow(CategoryNotFoundException::new);
        return ebookRepository.findAllByCategories(category)
                .stream()
                .map(ebookMapper::toEbookDto)
                .collect(Collectors.toList());
    }

    public EbookDto getEbookByShortName(String ebookShortName) throws EbookNotFoundException {
        Ebook ebook = ebookRepository.findFirstByShortName(ebookShortName).orElseThrow(EbookNotFoundException::new);

        return ebookMapper.toEbookDto(ebook);
    }

    public EbookDto getEbookById(Long ebookId) throws EbookNotFoundException {
        Ebook ebook = ebookRepository.findById(ebookId).orElseThrow(EbookNotFoundException::new);
        return ebookMapper.toEbookDto(ebook);
    }

    public void deleteEbook(Long ebookId) throws EbookNotFoundException {
        Ebook ebook = ebookRepository.findById(ebookId).orElseThrow(EbookNotFoundException::new);
        ebookRepository.delete(ebook);

    }

    public EbookDto createEbook(Ebook ebook) {
        ebookRepository.save(ebook);
        return ebookMapper.toEbookDto(ebook);
    }

    public EbookDto updateEbook(Long ebookId, Ebook ebook) throws EbookNotFoundException {
        Ebook retrievedEbook = ebookRepository.findById(ebookId).orElseThrow(EbookNotFoundException::new);
        retrievedEbook.setAuthor(ebook.getAuthor());
        retrievedEbook.setTitle(ebook.getTitle());
        retrievedEbook.setEbookFormat(ebook.getEbookFormat());

        ebookRepository.save(retrievedEbook);
        return ebookMapper.toEbookDto(retrievedEbook);
    }

}
