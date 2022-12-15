package com.tutorial.rest.webservices.restfulwebservices.helloworld;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HelloWorldController {

    @Value("${clarity.global.url}")
    private String clarityUrl;

    @Value("${clarity.user}")
    private String clarityUser;

    @Value("${clarity.password}")
    private String clarityPassword;

    @GetMapping(path = "/**")
    public ResponseEntity<String> helloWorldGet(HttpServletRequest req) {

        String url = clarityUrl + req.getRequestURI();
        ResponseEntity<String> resp = new RestTemplate().exchange(url, HttpMethod.GET, new HttpEntity<>(httpHeaders()), String.class, HttpStatus.ACCEPTED);

        System.out.println(req.getRequestURI());

        return resp;
    }

    @PostMapping(path = "/**")
    public ResponseEntity<String> helloWorldPost(HttpServletRequest req) {

        String url = clarityUrl + req.getRequestURI();
        ResponseEntity<String> resp = new RestTemplate().exchange(url, HttpMethod.POST, new HttpEntity<>(httpHeaders()), String.class, HttpStatus.ACCEPTED);

        System.out.println(req.getRequestURI());

        return resp;
    }

    private HttpHeaders httpHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "Basic " + getBasicAuthHeader());
        //httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        return httpHeaders;
    }

    private String getBasicAuthHeader() {
        String credentials = clarityUser + ":" + clarityPassword;

        return new String(Base64.encodeBase64String(credentials.getBytes()));
    }

}
