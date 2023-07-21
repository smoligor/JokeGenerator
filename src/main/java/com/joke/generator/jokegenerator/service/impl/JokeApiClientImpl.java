package com.joke.generator.jokegenerator.service.impl;

import com.joke.generator.jokegenerator.dto.JokeDto;
import com.joke.generator.jokegenerator.exception.ApiException;
import com.joke.generator.jokegenerator.service.JokeApiClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Service
@Slf4j
public class JokeApiClientImpl implements JokeApiClient {
    @Value("${joke.api.url}")
    private String jokeApiUrl;

    RestTemplate restTemplate = new RestTemplate();

    public JokeDto callJokeApi(){
        try {
            ResponseEntity<JokeDto> response = restTemplate.getForEntity(jokeApiUrl, JokeDto.class);
            return response.getBody();
        }catch (RuntimeException ex){
            log.error("Error occurred while calling joke api.");
            throw new ApiException("Error occurred while calling joke api.");
        }
    }
    @Async
    public Future<List<JokeDto>> getTenJokes(){
        List<JokeDto> jokes = new ArrayList<>();
        for(int i=1; i<=10; i++){
            ResponseEntity<JokeDto> response = restTemplate.getForEntity(jokeApiUrl, JokeDto.class);
            jokes.add(response.getBody());
        }
        return new AsyncResult<List<JokeDto>>(jokes);

    }
}
