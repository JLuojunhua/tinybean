package com.qqdzz.tinybean.service;

import com.qqdzz.tinybean.dao.MovieMapper;
import com.qqdzz.tinybean.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
@Service
public class MovieService {

    @Autowired
    private MovieMapper movieMapper;

    public boolean doAdd(Movie movie) {
        return true;
    }

    public boolean doModify(Movie movie) {
        return true;
    }

    public boolean doRemove(int id) {
        return true;
    }

    public boolean doRemove(List<Movie> movieList) {
        return true;
    }

    public Movie findById(int id) {
        Movie movie = new Movie();
        return movie;
    }

    public List<Movie> findAll() {
        List<Movie> movieList = new ArrayList<Movie>();
        return movieList;
    }

    public List<Movie> findByCondition(String movieName) {
        List<Movie> movieList = new ArrayList<Movie>();
        return movieList;
    }
}
