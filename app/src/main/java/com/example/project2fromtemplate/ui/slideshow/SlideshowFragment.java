package com.example.project2fromtemplate.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.project2fromtemplate.MovieViewer;

public class SlideshowFragment extends Fragment {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(getActivity(), MovieViewer.class);
        startActivity(intent);
    }
}