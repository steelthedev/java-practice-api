package com.iyanu.springapp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.iyanu.springapp.Repository.ContentRepository;
import com.iyanu.springapp.model.Content;
import com.iyanu.springapp.model.Status;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
    
    private final ContentRepository repository;

    public ContentController(ContentRepository repository){
        this.repository = repository;
    }

    ///find all content

    @GetMapping("")
    public List<Content> findAll(){
        return repository.findAll();
    }

    //CRUD

    @GetMapping("/{id}")
    public Content findById(@PathVariable int id){
        return repository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Content Not found"));

    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Content content){
        repository.save(content);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Content content,@PathVariable int id){
        if (!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found", null);
        }
        repository.save(content);
    }



    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        repository.deleteById(id);
    }

    @GetMapping("/filter/{keyword}")
    public List<Content> findByTitle(@PathVariable String keyword){
        return repository.findAllByTitleContains(keyword);
    }

    @GetMapping("/filter/status/{status}")
    public List<Content>  findByStatus(@PathVariable Status status){
        return repository.listByStatus(status);
    }   
}
