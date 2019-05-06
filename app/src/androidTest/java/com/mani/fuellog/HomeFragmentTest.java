package com.mani.fuellog;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.MutableLiveData;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.mani.fuellog.viewmodel.FuelLogViewModel;
import com.mani.fuellog.viewmodel.ViewModelUtil;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class HomeFragmentTest {

    @Mock
    FuelLogViewModel fuelLogViewModel;

    private MutableLiveData<Double> doubleMutableLiveData = new MutableLiveData<>();
    private FragmentScenario<HomeFragment> homeFragmentFragmentScenario;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        when(fuelLogViewModel.getAverageFuelConsumption()).thenReturn(doubleMutableLiveData);



        homeFragmentFragmentScenario = FragmentScenario.launchInContainer(HomeFragment.class,null,new FragmentFactory(){
            @NonNull
            @Override
            public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {
                return HomeFragment.newInstance(ViewModelUtil.createFor(fuelLogViewModel));
            }
        });
    }


    @Test
    public void shouldDisplay_averageConsumptionValue_postedOnMutableLiveData() {
        doubleMutableLiveData.postValue(4.5d);
        onView(withId(R.id.average_consumption_value)).check(matches(withText("4.5")));
    }

}