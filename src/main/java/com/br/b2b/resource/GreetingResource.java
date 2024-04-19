package com.br.b2b.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/me")
public class GreetingResource {

    @GetMapping
    public String greeting() {
        return "Api está no ar!";
    }
}