package com.github.khalin.vacationservice.healthcheck.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "OK";
    }
}
