package com.github.gserej.springbootebookstorebackend.category;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CategoryBootstrap {

    @Bean
    ApplicationRunner categoryInit(CategoryRepository categoryRepository) {
        return args -> {
            categoryRepository.saveAll(Arrays.asList(new Category("Java", "java"),
                    new Category("Android", "android"),
                    new Category("iOS", "ios"),
                    new Category("Linux", "linux"),
                    new Category("Python", "python"),
                    new Category("JavaScript", "javascript"),
                    new Category("C, C++", "c"),
                    new Category("C#", "c-sharp")
            ));
        };
    }
}
