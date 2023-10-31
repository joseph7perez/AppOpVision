package com.example.myapplication.ui.SubirFoto;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SubirFotoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SubirFotoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is subir foto fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}