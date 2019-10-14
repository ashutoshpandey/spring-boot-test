package com.focusit.testing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam("name") String name){
        return "Hello " + name;
    }

    @GetMapping("/hello-path/{name}")
    public String sayHelloPath(@PathVariable("name") String name){
        return "Hello " + name;
    }
}
