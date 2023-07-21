package com.joke.generator.jokegenerator.dto;

import lombok.Data;

import java.util.List;
@Data
public class JokeResponse {
    List<JokeDto> jokes;
}
