package dev.danvega.contentcalendar.model;

import dev.danvega.contentcalendar.repository.ContentCollectionRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ContentRepository extends ListCrudRepository<Content,Integer> {

    List<Content> findAll();
}
