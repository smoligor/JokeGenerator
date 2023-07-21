package com.joke.generator.jokegenerator.service;

import com.joke.generator.jokegenerator.dto.JokeDto;
import com.joke.generator.jokegenerator.dto.JokeResponse;

import java.util.List;

public interface JokeService {
    JokeResponse getJokes(int count);
}
