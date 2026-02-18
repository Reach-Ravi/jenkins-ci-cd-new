package com.example.jenkinscicdnew;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthcheckController {
    @GetMapping("/greetings")
    public String greeting(){
        return "This is My spring Docker project and we have achieved Docker";
    }
}
