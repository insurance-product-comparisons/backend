package ru.ya.insurance.controller.osago;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello, server time: " + LocalDateTime.now();
    }
}
