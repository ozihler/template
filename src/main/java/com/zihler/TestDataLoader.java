package com.zihler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestDataLoader implements ApplicationRunner {


    @Autowired
    public TestDataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) {

    }
}
