package com.example.project2fromtemplate.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("My name is Matt Mawson\nI am a student\nat Syracuse University!\nI live in Stoughton, Massachusetts\nI drive a Chevy Malibu");
    }

    public LiveData<String> getText() {
        return mText;
    }
}