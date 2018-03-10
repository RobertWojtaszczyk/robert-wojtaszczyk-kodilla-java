package com.kodilla.spring.library;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfig {

    /*@Bean
    public Library library() {
        return new Library(new LibraryDbController());  //????new LibraryDbController()??????
    }*/

    @Bean
    public Library library() {
        return new Library(libraryDbController());  //????new LibraryDbController()??????
    }
    @Bean
    public LibraryDbController libraryDbController() {
        return new LibraryDbController();
    }
}
