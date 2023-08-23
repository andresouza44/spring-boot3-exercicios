package dev.danvega.contentcalendar.repository;

import dev.danvega.contentcalendar.model.Content;
import dev.danvega.contentcalendar.model.Status;
import dev.danvega.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public  List <Content> findAll(){
        return contentList;
    }
    public Optional<Content> findById (Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();

    }

    public void saveContent(Content content){
        contentList.add(content);
    }

    public boolean existById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).count() ==1;

    }

    public  void save(Content content){
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);

    }

    public  void delete(Integer id){
        contentList.removeIf(c -> c.id().equals(id));

    }

    @PostConstruct
    private void init(){
        Content c1 = new Content(1,"My first CRUD","Finalmente meu CRUD está no Ar!", Status.IDEA, Type.ARTICLE,
                LocalDateTime.now(),null,"");

        Content c2 = new Content(2,"Lista de tarefas ","Lista de tarefas da semana", Status.IN_PROGRESS, Type.ARTICLE,
                LocalDateTime.now(),null,"");

        contentList.add(c1);
        contentList.add(c2);

    }



}
