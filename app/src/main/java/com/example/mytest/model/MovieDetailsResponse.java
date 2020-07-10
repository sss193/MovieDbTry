package com.example.mytest.model;

import com.google.gson.annotations.SerializedName;

public class MovieDetailsResponse {

    public String getPoster() {
        return Poster;
    }

    @SerializedName("Poster")
    private String Poster;
    @SerializedName("Title")
    private String Title;
    @SerializedName("Year")
    private String Year;

    @SerializedName("Director")
    private String Director;
    @SerializedName("Writer")
    private String Writer;

    public String getDirector() {
        return Director;
    }

    public String getWriter() {
        return Writer;
    }

    public String getActors() {
        return Actors;
    }

    @SerializedName("Actors")
    private String Actors;

    public String getTitle() {
        return Title;
    }

    public String getYear() {
        return Year;
    }

/*
    @SerializedName("Rated")
    private String Rated;
    @SerializedName("Released")
    private String Released;
    @SerializedName("Runtime")
    private String Runtime;
    @SerializedName("Genre")
    private String Genre;

    @SerializedName("Plot")
    private String Plot;
    @SerializedName("Language")
    private String Language;
    @SerializedName("Country")
    private String Country;
    @SerializedName("Awards")
    private String Awards;

    @SerializedName("Metascore")
    private String Metascore;
    @SerializedName("imdbRating")
    private String imdbRating;
    @SerializedName("imdbVotes")
    private String imdbVotes;
    @SerializedName("imdbID")
    private String imdbID;
    @SerializedName("Title")
    private String Type;
    @SerializedName("DVD")
    private String DVD;
    @SerializedName("BoxOffice")
    private String BoxOffice;
    @SerializedName("Production")
    private String Production;
    @SerializedName("Website")
    private String Website;
    @SerializedName("Response")
    private String Response;*/


}
