package com.mani.fuellog.viewmodel;

import android.app.Application;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class FuelLogViewModelTest {

    @Mock
    Application application;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void check() {
        FuelLogViewModel fuelLogViewModel = new FuelLogViewModel(application);
    }

}