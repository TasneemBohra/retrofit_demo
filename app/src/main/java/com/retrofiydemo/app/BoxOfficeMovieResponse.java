package com.retrofiydemo.app;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by tasneem on 16/11/15.
 */
public class BoxOfficeMovieResponse {
    @SerializedName("movies")
    List<Movies> movieList;

    public static BoxOfficeMovieResponse parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        Log.i("response ", response);
        BoxOfficeMovieResponse boxOfficeMovieResponse = gson.fromJson(response, BoxOfficeMovieResponse.class);
        return boxOfficeMovieResponse;
    }
}
