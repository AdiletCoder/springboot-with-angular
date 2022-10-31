package com.adik.todorest.basic;

import org.springframework.web.bind.annotation.*;

//@Controller
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class BasicAuthenticationController {

    @RequestMapping("/basicauth")
    public AuthenticationBean helloWorldBean() {
        //throw new RuntimeException("Some error has Happened! Contact Support at **");
        return new AuthenticationBean( "You are authenticated");
    }
}