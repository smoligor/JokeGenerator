package com.joke.generator.jokegenerator.service.impl;

import com.joke.generator.jokegenerator.dto.JokeDto;
import com.joke.generator.jokegenerator.dto.JokeResponse;
import com.joke.generator.jokegenerator.exception.ApiException;
import com.joke.generator.jokegenerator.service.JokeApiClient;
import com.joke.generator.jokegenerator.service.JokeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

@Service
public class JokeServiceImpl implements JokeService {
    JokeApiClient jokeApiClient;

    public JokeResponse getJokes(int count){
        List<JokeDto> jokes = new ArrayList<>();
        JokeResponse jokeResponse = new JokeResponse();
        List<Future<List<JokeDto>>> futures = new ArrayList<>();
        if(count==1){
            JokeDto jokeDto = jokeApiClient.callJokeApi();
            jokes.add(jokeDto);
            jokeResponse.setJokes(jokes);
            return jokeResponse;
        }
        try {
            if(count<10){
                Future<List<JokeDto>> tenJokes = jokeApiClient.getTenJokes();
                jokes.addAll(tenJokes.get());
                jokeResponse.setJokes(jokes
                    .stream()
                    .limit(count).toList());
                return jokeResponse;
            }
            for(int i = 0; i<count/10; i++){
                Future<List<JokeDto>> future =  jokeApiClient.getTenJokes();
                futures.add(future);
            }
            futures.forEach(e-> {
                try {
                    jokes.addAll(e.get());
                } catch (Exception ex) {
                    throw new ApiException("");
                }
            });
            jokeResponse.setJokes(jokes
                .stream()
                .limit(count).toList());

            return jokeResponse;
        }catch (Exception ex){
            throw new ApiException("Error occurred.");
        }
    }

    public JokeServiceImpl(JokeApiClient jokeApiClient) {
        this.jokeApiClient = jokeApiClient;
    }
}
