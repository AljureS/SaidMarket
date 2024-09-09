package com.said_market;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salute")
public class HelloWorldController {

    @GetMapping("/hi")
    public String salute(){
        return "Holi mundo";
    }
}
