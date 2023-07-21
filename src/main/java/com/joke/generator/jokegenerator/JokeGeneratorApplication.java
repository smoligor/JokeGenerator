package com.joke.generator.jokegenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class JokeGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(JokeGeneratorApplication.class, args);
    }

}
