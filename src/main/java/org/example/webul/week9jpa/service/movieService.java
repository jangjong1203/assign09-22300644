package org.example.webul.week9jpa.service;

import org.example.webul.week9jpa.dto.movieRequest;
import org.example.webul.week9jpa.dto.movieResponse;
import org.example.webul.week9jpa.entity.movie;
import org.example.webul.week9jpa.repository.movieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class movieService {
    private final movieRepository repository;

    public movieService(movieRepository repository){
        this.repository=repository;
    }

    public movieResponse create(movieRequest request) {
        movie saved = repository.save(new movie(request));
        return movieResponse.from(saved);
    }

    public List<movieResponse> findAll(){
        List<movie> movies = repository.findAll();
        List<movieResponse> response = new ArrayList<>();
        for (movie movie : movies) {
            response.add(movieResponse.from(movie));
        }
        return response;
    }
    public movieResponse findById(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found: " + id);
        }
        movie movie = repository.findById(id).get();
        return movieResponse.from(movie);
    }

    public movieResponse update(Long id, movieRequest request) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found: " + id);
        }
        movie m = repository.findById(id).get();
        m.update(request);
        movie updated = repository.save(m);
        return movieResponse.from(updated);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found: " + id);
        }
        repository.deleteById(id);
    }

}
