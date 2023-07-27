package com.iyanu.springapp.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Profile("production")
@Component
public class DataLoader implements CommandLineRunner {
    
    @Override
    public void run(String... args) throws Exception{
        System.out.println("Hello");
    }
}
