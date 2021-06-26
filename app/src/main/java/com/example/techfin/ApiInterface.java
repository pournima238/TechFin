package com.example.techfin;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    static final String BASE_URL="https://api.spoonacular.com/recipes/complexSearch/";
    @GET("?apiKey=99dcaee7b21948eb8da6432b66e7344f")
    Call<Movie> getMovies();
}
