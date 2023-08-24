package dev.danvega.contentcalendar.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeControler {


    @Value("${cc.welcomeMessage: Bem Vindo}")
    private String welcomeMessage;

    @Value(("${cc.about: about}"))
    private String about;



    @GetMapping
    public Map<String,String> home(){
        return  Map.of("welcomeMessage", welcomeMessage, "about", about);
    }
}
