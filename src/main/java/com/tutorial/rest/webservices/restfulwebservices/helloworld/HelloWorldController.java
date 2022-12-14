package com.tutorial.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/**")
    public String helloWorld(HttpServletRequest req) {
        String link = req.getRequestURL().toString();
        return link;
    }

}

