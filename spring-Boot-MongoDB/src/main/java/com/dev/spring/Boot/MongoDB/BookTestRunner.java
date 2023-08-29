package com.dev.spring.Boot.MongoDB;

import com.dev.spring.Boot.MongoDB.entity.Book;
import com.dev.spring.Boot.MongoDB.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BookTestRunner implements CommandLineRunner {
    @Autowired
    private BookRepository bookRepo;

    @Override
    public void run(String... args) throws Exception {

        // Removing old data if exists
        bookRepo.deleteAll();

        // Saving 4 books into DB
        bookRepo.saveAll(Arrays.asList(
                new Book(501, "Core Java", "Kathy Sierra", 1065.5),
                new Book(502, "Spring in Action", "Craig Walls", 940.75),
                new Book(503, "Hibernate in Action", "Gavin King", 889.25),
                new Book(504, "Practical MongoDB", "Shakuntala Gupta", 785.0)
        ));
        System.out.println("All Data saved into MongoDB");

        // Updating ID(PK) manually (allowed) : It will create one new record
        bookRepo.save(new Book("ISBN10:1484240251", 504,"Practical MongoDB", "Navin Sabharwal", 785.0)); // insert

        // Printing all books
        List<Book> bookList =  bookRepo.findAll();
        bookList.forEach(System.out::println);

    }

}
