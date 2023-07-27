package com.iyanu.springapp.Repository;

import com.iyanu.springapp.model.Content;
import com.iyanu.springapp.model.Status;
import com.iyanu.springapp.model.Type;

import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public class ContentCollectionRepository {
    
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll(){
        return contentList;
    }

    public Optional<Content> findById(int id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }


    public void save(Content content){
        contentList.removeIf(c->c.id().equals(content.id()));
        contentList.add(content);
    }

    @PostConstruct
    private void init(){
        Content c = new Content(
            1, 
            "Hello", 
            "yeah", 
            Status.IDEA, 
            Type.ARTICLE, 
            LocalDateTime.now(), 
            null, 
            "");
            
            contentList.add(c);
    }

      public boolean existsById(int id){
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }
     public void delete(int id){
       contentList.removeIf(c->c.id().equals(id));
    }
}
