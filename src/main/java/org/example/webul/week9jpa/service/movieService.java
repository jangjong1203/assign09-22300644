package org.example.webul.week9jpa.service;

import org.example.webul.week9jpa.dto.movieRequest;
import org.example.webul.week9jpa.dto.movieResponse;
import org.example.webul.week9jpa.entity.movie;
import org.example.webul.week9jpa.repository.movieRepository;
import org.springframework.stereotype.Service;

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
        movie movie = repository.findById(id).get();
        return movieResponse.from(movie);
    }

    public movieResponse update(Long id, movieRequest request) {
        movie m = repository.findById(id).get();
        m.update(request);
        movie updated = repository.save(m);
        return movieResponse.from(updated);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
