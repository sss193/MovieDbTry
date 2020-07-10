package com.example.mytest.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieRsponse {

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public List<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @SerializedName("Response")
    private String response;

    @SerializedName("totalResults")
    private String totalResults;

    @SerializedName("Search")
    private List<Movie> movieList;

}
