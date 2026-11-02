package org.example.webul.week9jpa.dto;

public record movieRequest(
        String title,
        String director,
        Double rating,
        String genre,
        Integer runningTime
) { }
