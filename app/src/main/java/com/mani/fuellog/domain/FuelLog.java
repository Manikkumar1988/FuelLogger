package com.mani.fuellog.domain;

public class FuelLog {
    private int currentOdometer;
    private int diffInOdometer;
    private double refuellingDate;
    private double fuelVolume;
    private double fuelUnitPrice;
    private double fuelVolumePrice;

    public FuelLog(int currentOdometer, int diffInOdometer, double refuellingDate, double fuelVolume, double fuelUnitPrice) {
        this.currentOdometer = currentOdometer;
        this.diffInOdometer = diffInOdometer;
        this.refuellingDate = refuellingDate;
        this.fuelVolume = fuelVolume;
        this.fuelUnitPrice = fuelUnitPrice;
        this.fuelVolumePrice = fuelUnitPrice * fuelVolume;
    }


    public int getCurrentOdometer() {
        return currentOdometer;
    }

    public void setCurrentOdometer(int currentOdometer) {
        this.currentOdometer = currentOdometer;
    }

    public int getDiffInOdometer() {
        return diffInOdometer;
    }

    public void setDiffInOdometer(int diffInOdometer) {
        this.diffInOdometer = diffInOdometer;
    }

    public double getRefuellingDate() {
        return refuellingDate;
    }

    public void setRefuellingDate(double refuellingDate) {
        this.refuellingDate = refuellingDate;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public double getFuelUnitPrice() {
        return fuelUnitPrice;
    }

    public void setFuelUnitPrice(double fuelUnitPrice) {
        this.fuelUnitPrice = fuelUnitPrice;
    }

    public double getFuelVolumePrice() {
        return fuelVolumePrice;
    }

    public void setFuelVolumePrice(double fuelVolumePrice) {
        this.fuelVolumePrice = fuelVolumePrice;
    }
}
