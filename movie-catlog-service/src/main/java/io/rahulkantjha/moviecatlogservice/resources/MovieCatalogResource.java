package io.rahulkantjha.moviecatlogservice.resources;

import io.rahulkantjha.moviecatlogservice.models.CatalogItem;
import io.rahulkantjha.moviecatlogservice.models.Rating;
import io.rahulkantjha.moviecatlogservice.models.movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogItem(@PathVariable("userId") String userId){

        RestTemplate restTemplate = new RestTemplate();

        // Get all rated movie ID
        List<Rating> ratings = Arrays.asList(
                new Rating("1234",4),new Rating("5678",3)
        );


        return  ratings.stream().map(rating -> {

            movie movie = restTemplate.getForObject("http://localhost:8082/movies/"+ rating.getMovieId() , movie.class);


          return   new CatalogItem(movie.getName(),"Test",rating.getRating());
        }).collect(Collectors.toList());

        //put them all together

    }
}
