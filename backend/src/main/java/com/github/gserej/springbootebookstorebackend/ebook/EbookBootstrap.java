package com.github.gserej.springbootebookstorebackend.ebook;

import com.github.gserej.springbootebookstorebackend.category.Category;
import com.github.gserej.springbootebookstorebackend.category.CategoryRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EbookBootstrap {

    @Bean
    ApplicationRunner ebookInit(EbookRepository ebookRepository, CategoryRepository categoryRepository) {
        return args -> {


//            new Category("Android", "android"),
//                    new Category("iOS", "ios"),
//                    new Category("Linux", "linux"),
//                    new Category("Python", "python"),
//                    new Category("JavaScript", "javascript"),
//                    new Category("C, C++", "c"),
//                    new Category("C#", "c-sharp")

            Category categoryJava = new Category("Java", "java");
            Category categorySpring = new Category("Spring", "spring");

            Ebook ebook1 = new Ebook();
            ebook1.setTitle("Spring 5: End-To-End Programming: Build enterprise-grade applications using Spring MVC, Hibernate, and RESTful APIs");
            ebook1.setShortName("spring-5-end-programming-enterprise-grade-apps");
            ebook1.setAuthor("de Oliveira, Claudio Eduardo");
            ebook1.setPages(760);
            ebook1.setPublicationYear(2019);
            ebook1.setImageUrl("https://scanlibs.com/wp-content/cover/spring-5-end-programming-enterprise-grade-apps.jpg");
            ebook1.setLanguage("English");
            ebook1.setIsbn("978-1789959666");
            ebook1.setEbookFormat(EbookFormat.pdf);
            ebook1.addCategory(categoryJava);
            ebook1.addCategory(categorySpring);
            ebookRepository.save(ebook1);

            Ebook ebook2 = new Ebook();
            ebook2.setTitle("Developing Java Applications with Spring and Spring Boot: Practical Spring and Spring Boot Solutions for Building effective Apps");
            ebook2.setShortName("developing-java-applications-spring-boot-practical");
            ebook2.setAuthor("Greg L. Turnquist");
            ebook2.setPages(982);
            ebook2.setPublicationYear(2020);
            ebook2.setImageUrl("https://scanlibs.com/wp-content/cover/developing-java-applications-spring-boot-practical.jpg");
            ebook2.setLanguage("English");
            ebook2.setIsbn("978-1789534757");
            ebook2.setEbookFormat(EbookFormat.epub);
//            ebook2.addCategory(categoryJava);
//            ebook2.addCategory(categorySpring);
            ebookRepository.save(ebook2);

            Ebook ebook3 = new Ebook();
            ebook3.setTitle("Objects First with Java: A Practical Introduction Using BlueJ, 6th Edition");
            ebook3.setShortName("objects-first-java-practical-bluej-6th");
            ebook3.setAuthor("David J. Barnes");
            ebook3.setPages(672);
            ebook3.setPublicationYear(2017);
            ebook3.setImageUrl("https://scanlibs.com/wp-content/cover/objects-first-java-practical-bluej-6th.jpg");
            ebook3.setLanguage("English");
            ebook3.setIsbn("978-0134477367");
            ebook3.setEbookFormat(EbookFormat.pdf);
//            ebook3.addCategory(categoryJava);
            ebookRepository.save(ebook3);

            Ebook ebook;

            ebook = new Ebook();
            ebook.setTitle("Spring 5: End-To-End Programming: Build enterprise-grade applications using Spring MVC, Hibernate, and RESTful APIs");
            ebook.setShortName("4");
            ebook.setAuthor("de Oliveira, Claudio Eduardo");
            ebook.setPages(760);
            ebook.setPublicationYear(2019);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/spring-5-end-programming-enterprise-grade-apps.jpg");
            ebook.setLanguage("English");
            ebook.setIsbn("978-1789959666");
            ebook.setEbookFormat(EbookFormat.pdf);
//            ebook.setCategories(categorySet1);
            ebookRepository.save(ebook);

            ebook = new Ebook();
            ebook.setTitle("Developing Java Applications with Spring and Spring Boot: Practical Spring and Spring Boot Solutions for Building effective Apps");
            ebook.setShortName("5");
            ebook.setAuthor("Greg L. Turnquist");
            ebook.setPages(982);
            ebook.setPublicationYear(2020);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/developing-java-applications-spring-boot-practical.jpg");
            ebook.setLanguage("English");
            ebook.setIsbn("978-1789534757");
            ebook.setEbookFormat(EbookFormat.epub);
//            ebook.setCategories(categorySet2);
            ebookRepository.save(ebook);

            ebook = new Ebook();
            ebook.setTitle("Objects First with Java: A Practical Introduction Using BlueJ, 6th Edition");
            ebook.setShortName("6");
            ebook.setAuthor("David J. Barnes");
            ebook.setPages(672);
            ebook.setPublicationYear(2017);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/objects-first-java-practical-bluej-6th.jpg");
            ebook.setLanguage("English");
            ebook.setIsbn("978-0134477367");
            ebook.setEbookFormat(EbookFormat.pdf);
//            ebook.setCategories(categorySet2);
            ebookRepository.save(ebook);

            ebook = new Ebook();
            ebook.setTitle("Spring 5: End-To-End Programming: Build enterprise-grade applications using Spring MVC, Hibernate, and RESTful APIs");
            ebook.setShortName("7");
            ebook.setAuthor("de Oliveira, Claudio Eduardo");
            ebook.setPages(760);
            ebook.setPublicationYear(2019);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/spring-5-end-programming-enterprise-grade-apps.jpg");
            ebook.setLanguage("English");
            ebook.setIsbn("978-1789959666");
            ebook.setEbookFormat(EbookFormat.pdf);
//            ebook.setCategories(categorySet1);
            ebookRepository.save(ebook);

            ebook = new Ebook();
            ebook.setTitle("Developing Java Applications with Spring and Spring Boot: Practical Spring and Spring Boot Solutions for Building effective Apps");
            ebook.setShortName("8");
            ebook.setAuthor("Greg L. Turnquist");
            ebook.setPages(982);
            ebook.setPublicationYear(2020);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/developing-java-applications-spring-boot-practical.jpg");
            ebook.setLanguage("English");
            ebook.setIsbn("978-1789534757");
            ebook.setEbookFormat(EbookFormat.epub);
//            ebook.setCategories(categorySet2);
            ebookRepository.save(ebook);

            ebook = new Ebook();
            ebook.setTitle("Objects First with Java: A Practical Introduction Using BlueJ, 6th Edition");
            ebook.setShortName("9");
            ebook.setAuthor("David J. Barnes");
            ebook.setPages(672);
            ebook.setPublicationYear(2017);
            ebook.setImageUrl("https://scanlibs.com/wp-content/cover/objects-first-java-practical-bluej-6th.jpg");
            ebook.setLanguage("English");
            ebook.setIsbn("978-0134477367");
            ebook.setEbookFormat(EbookFormat.pdf);
//            ebook.setCategories(categorySet2);
            ebookRepository.save(ebook);

        };
    }
}
