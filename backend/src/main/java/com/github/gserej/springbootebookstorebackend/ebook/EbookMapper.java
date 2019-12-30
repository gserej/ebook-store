package com.github.gserej.springbootebookstorebackend.ebook;


import org.mapstruct.Mapper;

@Mapper
public interface EbookMapper {

    EbookDto toEbookDto(Ebook ebook);

}
