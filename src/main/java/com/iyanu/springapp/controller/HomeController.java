package com.iyanu.springapp.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iyanu.springapp.config.ContentCalendarProperties;

@RestController
public class HomeController {
    
    private final ContentCalendarProperties properties;

    public HomeController(ContentCalendarProperties properties){
        this.properties = properties;
    }

    @GetMapping("/")
    public ContentCalendarProperties home(){
        return properties;
    }
}
