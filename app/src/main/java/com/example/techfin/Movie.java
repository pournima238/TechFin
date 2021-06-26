package com.example.techfin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Movie {
    @SerializedName("results")
    @Expose
    private List<Contact> results=null;

    public Movie(List<Contact> results) {
        this.results = results;
    }

    public List<Contact> getResults() {
        return results;
    }

    public void setResults(List<Contact> results) {
        this.results = results;
    }
}
