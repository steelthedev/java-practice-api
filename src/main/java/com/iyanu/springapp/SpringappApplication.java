package com.iyanu.springapp;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.iyanu.springapp.Repository.ContentRepository;
import com.iyanu.springapp.config.ContentCalendarProperties;
import com.iyanu.springapp.model.Content;
import com.iyanu.springapp.model.Status;
import com.iyanu.springapp.model.Type;


@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class SpringappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringappApplication.class, args);
	}
	

}
