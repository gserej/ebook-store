package com.github.gserej.springbootebookstorebackend.ebook;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


@Component
public class EbookBootstrap {

    @Bean
    ApplicationRunner init(EbookRepository ebookRepository) {
        return args -> {

//            Category category1 = new Category("Java");
//            Category category2 = new Category("Android");
//            Category category3 = new Category("iOS");
//
//            categoryRepository.save(category1);
//            categoryRepository.save(category2);
//            categoryRepository.save(category3);
//
//
//            Set<Category> categorySet1 = new HashSet<>();
//            categorySet1.add(category1);
//            categorySet1.add(category2);
//
//            Set<Category> categorySet2 = new HashSet<>();
//            categorySet2.add(category1);
//            categorySet2.add(category3);
//
//
            Ebook ebook;

            ebook = new Ebook();
            ebook.setTitle("Think Java: How to Think Like a Computer Scientist, 2nd Edition");
            ebook.setAuthor("John Cena");
            ebook.setPages(600);
            ebook.setPublicationYear(2020);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/data-mining-business-analytics-concepts-techniques.jpg");
            ebook.setLanguage("English");
//            ebook.setCategories(categorySet1);
            ebookRepository.save(ebook);

            ebook = new Ebook();
            ebook.setTitle("Pro Spring Security: Securing Spring Framework 5 and Boot 2-based Java Applications, 2nd Edition");
            ebook.setAuthor("John Cena");
            ebook.setPages(600);
            ebook.setPublicationYear(2020);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/python-projects-beginners-ten-week-programming.jpg");
            ebook.setLanguage("English");
//            ebook.setCategories(categorySet2);
            ebookRepository.save(ebook);

            ebook = new Ebook();
            ebook.setTitle("Java 11+ Essential Training");
            ebook.setAuthor("John Cena");
            ebook.setPages(500);
            ebook.setPublicationYear(2019);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/machine-learning-big-data-kdbq.jpg");
            ebook.setLanguage("English");
//            ebook.setCategories(categorySet1);
            ebookRepository.save(ebook);

            ebook = new Ebook();
            ebook.setTitle("ebook4");
            ebook.setAuthor("John Cena");
            ebook.setPages(600);
            ebook.setPublicationYear(2020);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/data-mining-business-analytics-concepts-techniques.jpg");
            ebook.setLanguage("English");
//            ebook.setCategories(categorySet1);
            ebookRepository.save(ebook);

            ebook = new Ebook();
            ebook.setTitle("ebook5");
            ebook.setAuthor("John Cena");
            ebook.setPages(600);
            ebook.setPublicationYear(2020);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/python-projects-beginners-ten-week-programming.jpg");
            ebook.setLanguage("English");
//            ebook.setCategories(categorySet1);
            ebookRepository.save(ebook);

            ebook = new Ebook();
            ebook.setTitle("ebook6");
            ebook.setAuthor("John Cena");
            ebook.setPages(500);
            ebook.setPublicationYear(2019);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/machine-learning-big-data-kdbq.jpg");
            ebook.setLanguage("English");
//            ebook.setCategories(categorySet2);
            ebookRepository.save(ebook);

            ebook = new Ebook();
            ebook.setTitle("ebook7");
            ebook.setAuthor("John Cena");
            ebook.setPages(600);
            ebook.setPublicationYear(2020);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/data-mining-business-analytics-concepts-techniques.jpg");
            ebook.setLanguage("English");
//            ebook.setCategories(categorySet1);
            ebookRepository.save(ebook);

            ebook = new Ebook();
            ebook.setTitle("ebook8");
            ebook.setAuthor("John Cena");
            ebook.setPages(600);
            ebook.setPublicationYear(2020);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/python-projects-beginners-ten-week-programming.jpg");
            ebook.setLanguage("English");
//            ebook.setCategories(categorySet1);
            ebookRepository.save(ebook);

            ebook = new Ebook();
            ebook.setTitle("ebook9");
            ebook.setAuthor("John Cena");
            ebook.setPages(500);
            ebook.setPublicationYear(2019);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/machine-learning-big-data-kdbq.jpg");
            ebook.setLanguage("English");
//            ebook.setCategories(categorySet1);
            ebookRepository.save(ebook);

        };
    }
}
