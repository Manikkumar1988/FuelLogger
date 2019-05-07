package com.mani.fuellog.viewmodel;

public class FuelStat {
    private Double averageConsumption, drivingCost;
    private long totalDistance, totalAmount, totalFuelConsumption;

    public FuelStat(Double averageConsumption, Double drivingCost, long totalDistance, long totalAmount, long totalFuelConsumption) {
        this.averageConsumption = averageConsumption;
        this.drivingCost = drivingCost;
        this.totalDistance = totalDistance;
        this.totalAmount = totalAmount;
        this.totalFuelConsumption = totalFuelConsumption;
    }

    public Double getAverageConsumption() {
        return averageConsumption;
    }

    public Double getDrivingCost() {
        return drivingCost;
    }

    public long getTotalDistance() {
        return totalDistance;
    }

    public long getTotalAmount() {
        return totalAmount;
    }

    public long getTotalFuelConsumption() {
        return totalFuelConsumption;
    }
}
