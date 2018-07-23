package com.qqdzz.tinybean.controller;

import com.qqdzz.tinybean.entity.JsonResult;
import com.qqdzz.tinybean.entity.Movie;
import com.qqdzz.tinybean.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * 根据movieName/director/mainactor/classification/date进行搜索
     * @param condition
     * @return
     */
    @GetMapping("/movie")
    public JsonResult<Movie> getMovieByCondition(String condition){
        List<Movie> movieList = new ArrayList<Movie>();
        String movieName = condition;
        Movie movie = movieService.findByMovieName(movieName);
        if (movie != null) {
            movieList.add(movie);
        }

        String director = condition;
        List<Movie> movieByDirector = movieService.findByDirector(director);
        if (movieByDirector != null) {
            for (Movie m : movieByDirector) {
                movieList.add(m);
            }
        }

        String mainactor = condition;
        List<Movie> movieByMainactor = movieService.findByMainactor(mainactor);
        if (movieByMainactor != null) {
            for (Movie m : movieByMainactor) {
                movieList.add(m);
            }
        }
        String classification = condition;
        List<Movie> movieByClassification = movieService.findByClassification(classification);
        if (movieByClassification != null) {
            for (Movie m : movieByClassification) {
                movieList.add(m);
            }
        }
        String date = condition;
        List<Movie> movieByDate = movieService.findByDate(date);
        if (movieByDate != null) {
            for (Movie m : movieByDate) {
                movieList.add(m);
            }
        }
        return new JsonResult<Movie>(movieList);
    }

    @GetMapping("/movieById")
    public JsonResult<Movie> getMovieById(Integer movieId){
        Movie movie = movieService.findById(movieId);
        return new JsonResult<Movie>(movie);
    }

    @DeleteMapping("/movie")
    public JsonResult<Movie> deleteMovieById(Integer movieId){
        movieService.doRemove(movieId);
        return this.getMovieById(movieId);
    }

    @PutMapping("/movie")
    public JsonResult uploadMovie(@RequestBody Movie movie){
        movieService.doAdd(movie);
        return new JsonResult("添加成功");
    }
}
