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

    public EbookDto getEbookById(Long id) throws EbookNotFoundException {
        Ebook ebook = ebookRepository.findById(id).orElseThrow(EbookNotFoundException::new);

        return ebookMapper.toEbookDto(ebook);
    }


}
