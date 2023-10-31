package com.example.myapplication.ui.TomarFoto;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TomarFotoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TomarFotoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is tomar foto fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}