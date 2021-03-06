package com.retrofiydemo.app;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    String response = " { \"movies\": [" +
            "  {" +
            "    \"id\": 771305050," +
            "    \"title\": \"Straight Outta Compton\", " +
            "    \"year\": 2015 " +
            "  }, " +
            "  { " +
            "    \"id\": 771357161, " +
            "    \"title\": \"Mission: Impossible Rogue Nation\", " +
            "    \"year\": 2015" +
            "  }" +

            "] }";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String movieStr = "";
                BoxOfficeMovieResponse responseMovie = BoxOfficeMovieResponse.parseJSON(response);
                if (responseMovie != null) {
                    for (int i = 0; i<responseMovie.movieList.size(); i++) {
                        Movies movies = responseMovie.movieList.get(i);
                        Log.i("Movie ", movies.getTitle());
                        movieStr = movies.getTitle() + "\n" + movieStr;
                    }
                }
                Snackbar.make(view, movieStr, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
