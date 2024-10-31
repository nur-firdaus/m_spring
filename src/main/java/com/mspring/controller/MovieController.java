package com.mspring.controller;

import com.mspring.model.Movie;
import com.mspring.service.MovieService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<Page<Movie>> getAllMovies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        log.info("Request --> All Movie {}", size);
        Page<Movie> movies = movieService.getAllMovies(page, size);
        log.info("Response --> {}",movies.getContent());
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        log.info("Request --> Movie id {}", id);
        Optional<Movie> movie = movieService.getMovieById(id);
        log.info("Response --> {}", movie.orElse(null));
        return movie.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMoviesByTitle(@RequestParam String title) {
        log.info("Request --> Movie title {}", title);
        List<Movie> movies = movieService.searchMoviesByTitle(title);
        log.info("Response --> {}", movies);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/rating")
    public ResponseEntity<List<Movie>> getMoviesByRating(@RequestParam BigDecimal rating) {
        log.info("Request --> rating {}", rating);
        List<Movie> movies = movieService.getMoviesByRating(rating);
        log.info("Response --> {}", movies);
        return ResponseEntity.ok(movies);
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        log.info("Request --> Save Movie {}", movie);
        Movie createdMovie = movieService.createMovie(movie);
        log.info("Response --> {}", createdMovie);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMovie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movieDetails) {
        try {
            log.info("Request --> update Movie {} {}", id, movieDetails);
            Movie updatedMovie = movieService.updateMovie(id, movieDetails);
            log.info("Response --> {}", updatedMovie);
            return ResponseEntity.ok(updatedMovie);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        try {
            log.info("Request --> delete Movie {}", id);
            movieService.deleteMovie(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
