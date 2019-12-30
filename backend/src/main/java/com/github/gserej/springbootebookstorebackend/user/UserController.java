package com.github.gserej.springbootebookstorebackend.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@CrossOrigin("*")
@RequestMapping("/api/v1/")
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PreAuthorize("hasAnyAuthority('MODERATOR')")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }
}
