package com.rcf.bluetoothexperiment.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<Integer> value;

    public DashboardViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");

        value = new MutableLiveData<>();
        value.setValue(33);


    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<Integer> getValue() {
        return value;
    }
}