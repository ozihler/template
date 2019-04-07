package com.zihler.usecases.sampleusecase;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class SampleRestController {

    @GetMapping("/admin")
    public String admin() {
        return "Admin Hello World";
    }

    @GetMapping
    public String sample() {
        return "Hello World";
    }
}
