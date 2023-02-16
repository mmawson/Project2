package com.example.project2fromtemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.project2fromtemplate.ui.OneMovie.OneMovieFragment;

public class MovieTask2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_task2);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, OneMovieFragment.newInstance())//25, "SuperBad", "1979", 3, "A drink of water"))
                    .commitNow();
        }
    }
}