package com.github.gserej.springbootebookstorebackend.category;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("demo")
@Component
public class CategoryBootstrap {

    @Bean
    ApplicationRunner categoryInit(CategoryRepository categoryRepository) {
        return args -> {

            Category category1 = new Category("Java");
            Category category2 = new Category("Android");
            Category category3 = new Category("iOS");

            categoryRepository.save(category1);
            categoryRepository.save(category2);
            categoryRepository.save(category3);
        };
    }
}
