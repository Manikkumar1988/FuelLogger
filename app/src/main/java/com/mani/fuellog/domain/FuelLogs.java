package com.mani.fuellog.domain;

import java.util.ArrayList;
import java.util.List;

public class FuelLogs {
    private List<FuelLog> fuelLogList = new ArrayList<>();


    public void addTo(FuelLog fuelLog) {
        fuelLogList.add(fuelLog);
    }

    public double averageConsumption() {
        long totalDistance = 0;
        double totalConsumption = 0;

        for(FuelLog fuelLog:fuelLogList) {
            totalDistance += fuelLog.getDiffInOdometer();
            totalConsumption += fuelLog.getFuelVolume();
        }

        if(isFirstFillUp(totalDistance))
            return 0;

        return totalConsumption/totalDistance;
    }

    private boolean isFirstFillUp(long totalDistance) {
        return totalDistance == 0;
    }
}
