package com.qqdzz.controller;

import com.qqdzz.entity.JsonResult;
import com.qqdzz.entity.Movie;
import com.qqdzz.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     *
     * @param condition
     * @return
     */
    @GetMapping("/movie")
    public JsonResult<Movie> getMovieByCondition(String condition){

    }

    @DeleteMapping("/movie")
    public
}
