package com.example.spring_demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping("/")
    public String index() {
        return "Hello World!";
    }

    @RequestMapping("/esp")
    public String indexEsp() {
        return "Hola Mundo!";
    }
}
