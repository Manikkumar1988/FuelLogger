package com.mani.fuellog.domain;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class FuelLogsTest {

    FuelLogs fuelLogs = new FuelLogs();


    @Before
    public void setUp() {

    }

    @Test
    public void averageConsumption_shouldReturnZero_forFirstFillUp() {

        fuelLogs.addTo(new FuelLog(4000,0,System.currentTimeMillis(),2.54,81.0));

        double averageConsumption =  fuelLogs.averageConsumption();

        assertEquals(0,averageConsumption,0.0d);

    }


    @Test
    public void averageConsumption_shouldReturn033_forSecondFillUp() {

        fuelLogs.addTo(new FuelLog(4000,0,System.currentTimeMillis(),2.54,81.0));
        fuelLogs.addTo(new FuelLog(4087,87,System.currentTimeMillis(),2.44,81.0));
        fuelLogs.addTo(new FuelLog(4222,135,System.currentTimeMillis(),2.40,83.0));

        double averageConsumption =  fuelLogs.averageConsumption();

        assertEquals(0.033,averageConsumption,0.2d);

    }
}