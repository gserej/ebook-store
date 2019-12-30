package com.github.gserej.springbootebookstorebackend.ebook;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class EbookService {

    private final EbookRepository ebookRepository;
    private final EbookMapper ebookMapper;


    public EbookService(EbookRepository ebookRepository, EbookMapper ebookMapper) {
        this.ebookRepository = ebookRepository;
        this.ebookMapper = ebookMapper;
    }

    public List<EbookDto> getAllEbooks() {
        return ebookRepository.findAll()
                .stream()
                .map(ebookMapper::toEbookDto)
                .collect(Collectors.toList());

    }

    public List<EbookDto> getEbooksByCategory(Long id) {
        return ebookRepository.getEbookByCategoriesIs(id)
                .stream()
                .map(ebookMapper::toEbookDto)
                .collect(Collectors.toList());
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
        retrievedEbook.setFormat(ebook.getFormat());

        ebookRepository.save(retrievedEbook);
        return ebookMapper.toEbookDto(retrievedEbook);
    }

}
