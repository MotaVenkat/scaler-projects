package com.example.oauth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping ("/hi")
    public String hellow(){
        return "Venkata Naidu " +
                "Lingappagaripalli (village) " +
                "Bukkapatanam (mandal) " +
                "SriSathyaSai (district) " +
                "Andhrapradesh (state) " +
                "pincode : 515154 ";

    }

}
