package com.example.intelligentstore.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Commandlinerunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("hello");

    }
}
