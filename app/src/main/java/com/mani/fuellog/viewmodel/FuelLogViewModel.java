package com.mani.fuellog.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class FuelLogViewModel extends AndroidViewModel {

    private MutableLiveData<Double> averageFuelConsumption = new MutableLiveData<>();

    public FuelLogViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Double> getAverageFuelConsumption() {
        return averageFuelConsumption;
    }
}
