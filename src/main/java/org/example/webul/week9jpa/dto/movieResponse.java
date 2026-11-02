package org.example.webul.week9jpa.dto;

import org.example.webul.week9jpa.entity.movie;

public record movieResponse(
        Long id,
        String title,
        String director,
        Double rating,
        String genre,
        Integer runningTime
) {
    public static movieResponse from(movie movie) {
        return new movieResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getDirector(),
                movie.getRating(),
                movie.getGenre(),
                movie.getRunningTime()
        );
    }
}