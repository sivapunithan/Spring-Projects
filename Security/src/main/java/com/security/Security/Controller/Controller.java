package com.security.Security.Controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping ("/punithan")
    public String welcome(HttpServletRequest request) {
        return "Welcome to the Security System!"+ request.getRequestURI();
    }
}
