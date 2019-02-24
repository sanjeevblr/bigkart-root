package com.edureka.jan26.mstraining.securitysimple.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProtectedResource {

    @GetMapping(value = "hi")
    public String hello(){
        return "Hi and Hello";
    }
}
