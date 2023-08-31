package com.silvilabs.bookmarks.service;

import com.silvilabs.bookmarks.domain.Bookmark;
import com.silvilabs.bookmarks.domain.BookmarkDTO;
import com.silvilabs.bookmarks.domain.FindBookMarkQuery;
import com.silvilabs.bookmarks.domain.PageResult;
import com.silvilabs.bookmarks.repository.BookmarkRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<Bookmark> findAll() {
        return repo.findAll();
    }

    public PageResult<BookmarkDTO> findBookmarks(FindBookMarkQuery query) {
        Sort sort = Sort.by(Sort.Direction.DESC, "createdAt");
        //from user POV, page number starts from 1, but for Spring Data JPA page number starts from 0.
        int pageNo = query.pageNo() > 0 ? query.pageNo() - 1 : 0;
        Pageable pageable = PageRequest.of(pageNo, query.pageSize(), sort);
        Page<BookmarkDTO> page = repo.findBookmars(pageable);
        return new PageResult<>(
                page.getContent(),
                page.getTotalElements(),
                page.getNumber() + 1, // for user page number starts from 1
                page.getTotalPages(),
                page.isFirst(),
                page.isLast(),
                page.hasNext(),
                page.hasPrevious());
    }


    }

