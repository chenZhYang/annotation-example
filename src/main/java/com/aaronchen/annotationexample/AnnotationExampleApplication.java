package com.aaronchen.annotationexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AnnotationExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AnnotationExampleApplication.class, args);
    }

    @GetMapping("/PathVariable/{id}/{name}")
    public String testPathVariable(@PathVariable("id") Long id,@PathVariable("name") String name){
        return "id = " + id + ",name = "+name;
    }
}
