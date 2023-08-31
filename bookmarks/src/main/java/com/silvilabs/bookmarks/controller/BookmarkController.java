package com.silvilabs.bookmarks.controller;


import com.silvilabs.bookmarks.domain.Bookmark;
import com.silvilabs.bookmarks.domain.BookmarkDTO;
import com.silvilabs.bookmarks.domain.FindBookMarkQuery;
import com.silvilabs.bookmarks.domain.PageResult;
import com.silvilabs.bookmarks.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {

    @Autowired
    BookmarkService service;

    @GetMapping
    PageResult<BookmarkDTO> findBookmarks(
            @RequestParam(name = "page", defaultValue = "1") Integer pageNo,
            @RequestParam(name = "size", defaultValue = "10") Integer pageSize) {

        FindBookMarkQuery query = new FindBookMarkQuery(pageNo, pageSize);
        return service.findBookmarks(query);


    }/*@GetMapping
    public ResponseEntity<List<Bookmark>> findAll(){
        List <Bookmark> book = service.findAll();
        return ResponseEntity.ok().body(book);
    }*/
}
