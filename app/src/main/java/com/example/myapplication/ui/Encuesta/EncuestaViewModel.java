package com.example.myapplication.ui.Encuesta;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EncuestaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EncuestaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is encuesta fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}