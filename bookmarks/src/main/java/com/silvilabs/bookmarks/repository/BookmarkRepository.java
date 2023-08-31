package com.silvilabs.bookmarks.repository;

import com.silvilabs.bookmarks.domain.Bookmark;
import com.silvilabs.bookmarks.domain.BookmarkDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookmarkRepository  extends JpaRepository<Bookmark, Long> {
    @Query("""
            SELECT
                new com.silvilabs.bookmarks.domain.BookmarkDTO(b.id, b.title, b.url, b.createdAt)
            FROM Bookmark b
            """)
    Page<BookmarkDTO> findBookmars(Pageable pageable);
}
