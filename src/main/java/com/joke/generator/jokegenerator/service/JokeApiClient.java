package com.joke.generator.jokegenerator.service;

import com.joke.generator.jokegenerator.dto.JokeDto;

import java.util.List;
import java.util.concurrent.Future;

public interface JokeApiClient {
    JokeDto callJokeApi();
    Future<List<JokeDto>> getTenJokes();
}
