package com.dev.spring.Boot.MongoDB.repository;

import com.dev.spring.Boot.MongoDB.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,String> {

}
