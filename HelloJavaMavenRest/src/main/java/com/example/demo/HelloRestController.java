package com.example.demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @org.springframework.web.bind.annotation.GetMapping("/")
    public String hello() {
        return "Hello World!";
    }
}
