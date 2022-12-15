package com.tutorial.rest.webservices.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloWorldController {

    @Value("${clarity.global.url}")
    private String clarityUrl;

    @GetMapping(path = "/**")
    public ResponseEntity<String> helloWorld(HttpServletRequest req) {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @GetMapping(path = "/test")
    public String helloWorldTest(HttpServletRequest req) {

        String url = clarityUrl + "/test";
        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(url, String.class);

        return result;
    }

}
