package io.rahulkantjha.movieinfoservice;

import io.rahulkantjha.movieinfoservice.model.movie;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @RequestMapping("/{movieId}")
    public movie getMovieInfo(@PathVariable("movieId") String movieId){

        return  new movie(movieId,"Test name");

    }
}
