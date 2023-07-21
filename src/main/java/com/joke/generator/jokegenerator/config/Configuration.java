package com.joke.generator.jokegenerator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.beans.BeanProperty;
@org.springframework.context.annotation.Configuration
public class Configuration {
    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
