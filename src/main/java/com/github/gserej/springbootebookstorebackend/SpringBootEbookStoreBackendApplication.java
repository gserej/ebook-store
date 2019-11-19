package com.github.gserej.springbootebookstorebackend;

import com.github.gserej.springbootebookstorebackend.model.Ebook;
import com.github.gserej.springbootebookstorebackend.repository.EbookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootEbookStoreBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootEbookStoreBackendApplication.class, args);
    }


    @Bean
    ApplicationRunner init(EbookRepository repository) {
        return args -> {
            Ebook ebook;

            ebook = new Ebook();
            ebook.setTitle("ebook1");
            ebook.setAuthor("John Cena");
            ebook.setPages(600);
            ebook.setPublicationYear(2020);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/data-mining-business-analytics-concepts-techniques.jpg");
            ebook.setLanguage("English");
            repository.save(ebook);

            ebook = new Ebook();
            ebook.setTitle("ebook2");
            ebook.setAuthor("John Cena");
            ebook.setPages(600);
            ebook.setPublicationYear(2020);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/python-projects-beginners-ten-week-programming.jpg");
            ebook.setLanguage("English");
            repository.save(ebook);

            ebook = new Ebook();
            ebook.setTitle("ebook3");
            ebook.setAuthor("John Cena");
            ebook.setPages(500);
            ebook.setPublicationYear(2019);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/machine-learning-big-data-kdbq.jpg");
            ebook.setLanguage("English");
            repository.save(ebook);

        };
    }
}
