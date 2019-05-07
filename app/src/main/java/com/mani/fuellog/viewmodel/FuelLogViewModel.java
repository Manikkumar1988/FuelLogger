package com.mani.fuellog.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.mani.fuellog.domain.FuelStat;

public class FuelLogViewModel extends AndroidViewModel {

    private MutableLiveData<FuelStat> averageFuelConsumption = new MutableLiveData<>();

    public FuelLogViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<FuelStat> getAverageFuelConsumption() {
        return averageFuelConsumption;
    }
}
