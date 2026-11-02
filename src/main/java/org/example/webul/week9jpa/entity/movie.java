package org.example.webul.week9jpa.entity;

import jakarta.persistence.*;
import org.example.webul.week9jpa.dto.movieRequest;

@Entity
@Table(name="moviejpa")
public class movie{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length = 100)
    private String title;

    @Column(nullable = false,length = 100)
    private String director;

    @Column(nullable = false)
    private Double rating;

    @Column(nullable = false,length = 50)
    private String genre;

    @Column(nullable = false)
    private Integer runningTime;

    protected movie() { }

    public movie(movieRequest request) {
        this.title = request.title();
        this.director = request.director();
        this.rating = request.rating();
        this.genre = request.genre();
        this.runningTime = request.runningTime();
    }

    public void update(movieRequest request) {
        this.title = request.title();
        this.director = request.director();
        this.rating = request.rating();
        this.genre = request.genre();
        this.runningTime = request.runningTime();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public Double getRating() {
        return rating;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getRunningTime() {
        return runningTime;
    }
}

