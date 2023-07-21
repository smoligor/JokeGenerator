package com.joke.generator.jokegenerator.dto;

import lombok.Data;

@Data
public class JokeDto {
    private String type;
    private String setup;
    private String punchline;
    private long id;
}
