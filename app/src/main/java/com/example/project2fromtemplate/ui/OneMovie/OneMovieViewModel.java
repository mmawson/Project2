package com.example.project2fromtemplate.ui.OneMovie;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.project2fromtemplate.MovieData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OneMovieViewModel extends ViewModel {

    private MutableLiveData<Integer> mImage;
    private MutableLiveData<String> mTitle, mDescription, mYear, mActors;
    private MutableLiveData<Float> mRating;
    public int j= 0;
    private MovieData md = new MovieData();
    List<Map<String, ?>> moviesList = md.getMoviesList();

    public OneMovieViewModel() {
        HashMap movie = md.getItem(j);
        mDescription = new MutableLiveData<>();
        mDescription.setValue((String) movie.get("description"));
        mImage = new MutableLiveData<>();
        mImage.setValue((Integer) movie.get("image"));
        mTitle = new MutableLiveData<>();
        mTitle.setValue((String) movie.get("name"));
        mYear = new MutableLiveData<>();
        mYear.setValue((String) movie.get("year"));
        mRating = new MutableLiveData<Float>();
        mRating.setValue((float) md.getReview(j));
//        mRating.setValue((Float) movie.get("rating"));
        mActors = new MutableLiveData<>();
        mActors.setValue((String) movie.get("stars"));

        //mRating = new MutableLiveData<>();
        //mRating.setValue((double) movie.get("rating"));
    }

    public void update(int i) {
        j = i;
        HashMap movie = md.getItem(j);
        mDescription = new MutableLiveData<>();
        mDescription.setValue((String) movie.get("description"));
        mImage = new MutableLiveData<>();
        mImage.setValue((Integer) movie.get("image"));
        mTitle = new MutableLiveData<>();
        mTitle.setValue((String) movie.get("name"));
        mYear = new MutableLiveData<>();
        mYear.setValue((String) movie.get("year"));
        mRating = new MutableLiveData<Float>();
        mRating.setValue((float) md.getReview(j));
//        mRating.setValue((Float) movie.get("rating"));
        mActors = new MutableLiveData<>();
        mActors.setValue((String) movie.get("stars"));
    }

    public LiveData<Integer> getImage() {
        return mImage;
    }

    public LiveData<String> getDescription() {
        return mDescription;
    }

    public LiveData<String> getTitleText() {
        return mTitle;
    }

    public LiveData<String> getYear() {
        return mYear;
    }

    public LiveData<Float> getRating() {
        return mRating;
    }

    public LiveData<String> getActors() { return mActors; }
}
    /*
		movie.put("year", year); string
		movie.put("rating",rating); double
		movie.put("director",director);
		movie.put("stars",stars); STRING
		movie.put("url",url);
		movie.put("selection",false);*/