package com.github.gserej.springbootebookstorebackend.ebook;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Ebook was not found")
public class EbookNotFoundException extends Exception {

//    public EbookNotFoundException(String message){
//        super(message);
//    }
}
