package com.github.gserej.springbootebookstorebackend.user;


import com.github.gserej.springbootebookstorebackend.model.Authority;
import lombok.Data;

import java.sql.Date;
import java.util.Set;

@Data
public class UserDto {

    private Long id;
    private String userName;
    private String password;

    private Date dateCreated;
    private Set<Authority> authorities;
}
