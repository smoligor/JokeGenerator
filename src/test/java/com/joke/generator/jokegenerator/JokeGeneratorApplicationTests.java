package com.joke.generator.jokegenerator;

import com.joke.generator.jokegenerator.dto.JokeDto;
import com.joke.generator.jokegenerator.dto.JokeResponse;
import com.joke.generator.jokegenerator.service.JokeApiClient;
import com.joke.generator.jokegenerator.service.JokeService;
import com.joke.generator.jokegenerator.service.impl.JokeApiClientImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class JokeGeneratorApplicationTests {

    @MockBean
    private RestTemplate restTemplate;

    @InjectMocks
    private JokeApiClient jokeApiClient = new JokeApiClientImpl();

    @Autowired
    private JokeService jokeService;
    @Value("${joke.api.url}")
    private String url;

    @Test
    public void get1JokeWorksCorrectlyTest(){

        JokeResponse jokes = jokeService.getJokes(1);
        assertEquals(1,jokes.getJokes().size());
        assertEquals(1, jokes.getJokes().get(0).getId());

    }
    @Test
    public void get5JokesWorksCorrectlyTest(){

        JokeResponse jokes = jokeService.getJokes(5);
        assertEquals(5,jokes.getJokes().size());
        assertEquals(1, jokes.getJokes().get(0).getId());
    }
    @Test
    public void get35JokesWorksCorrectlyTest(){

        JokeResponse jokes = jokeService.getJokes(35);
        assertEquals(35,jokes.getJokes().size());
        assertEquals(1, jokes.getJokes().get(0).getId());
    }


    @Test
    void contextLoads() {
    }
    @BeforeEach
    public void init(){
        JokeDto jokeDto = new JokeDto();
        jokeDto.setId(1);
        jokeDto.setPunchline("Line1");
        jokeDto.setSetup("Setup1");
        Mockito
            .when(restTemplate.getForEntity(url, JokeDto.class)).thenReturn(new ResponseEntity(jokeDto, HttpStatus.OK));

}
}
