package com.joke.generator.jokegenerator.controller;


import com.joke.generator.jokegenerator.dto.JokeResponse;
import com.joke.generator.jokegenerator.service.JokeService;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JokeController {

    JokeService jokeService;

    @GetMapping("/jokes")
    public JokeResponse getJoke(@RequestParam(defaultValue = "5") int count){
    return jokeService.getJokes(count);
    }

    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }
}
