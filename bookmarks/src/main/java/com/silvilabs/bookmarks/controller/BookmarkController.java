package com.silvilabs.bookmarks.controller;


import com.silvilabs.bookmarks.domain.Bookmark;
import com.silvilabs.bookmarks.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {

    @Autowired
    BookmarkService service;

    @GetMapping
    public ResponseEntity<List<Bookmark>> findAll(){
        List <Bookmark> book = service.findAll();
        return ResponseEntity.ok().body(book);
    }
}
