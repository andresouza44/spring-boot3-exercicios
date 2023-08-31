package com.silvilabs.bookmarks.repository;

import com.silvilabs.bookmarks.domain.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookmarkRepository  extends JpaRepository<Bookmark, Long> {
}
