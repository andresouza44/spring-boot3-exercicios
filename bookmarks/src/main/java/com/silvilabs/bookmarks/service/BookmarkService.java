package com.silvilabs.bookmarks.service;

import com.silvilabs.bookmarks.domain.Bookmark;
import com.silvilabs.bookmarks.repository.BookmarkRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class BookmarkService {
    final BookmarkRepository repo;

    BookmarkService(BookmarkRepository repo) {
        this.repo = repo;
    }

    public List<Bookmark> findAll(){
        return repo.findAll();
    }


}
