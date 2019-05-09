package com.mani.fuellog;

import androidx.annotation.NonNull;
import androidx.arch.core.executor.testing.CountingTaskExecutorRule;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.MutableLiveData;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.mani.fuellog.ui.HomeFragment;
import com.mani.fuellog.viewmodel.FuelLogViewModel;
import com.mani.fuellog.domain.FuelStat;
import com.mani.fuellog.viewmodel.ViewModelUtil;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.when;

@RunWith(AndroidJUnit4.class)
public class HomeFragmentTest {

//    @Rule
//    private CountingTaskExecutorRule testRule = new CountingTaskExecutorRule();

    @Mock
    private FuelLogViewModel fuelLogViewModel;

    private MutableLiveData<FuelStat> doubleMutableLiveData = new MutableLiveData<>();


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        when(fuelLogViewModel.getAverageFuelConsumption()).thenReturn(doubleMutableLiveData);


         FragmentScenario.launchInContainer(HomeFragment.class,null,new FragmentFactory(){
            @NonNull
            @Override
            public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {
                return HomeFragment.newInstance(ViewModelUtil.createFor(fuelLogViewModel));
            }
        }).moveToState(Lifecycle.State.RESUMED);
    }


    @Test
    public void shouldDisplay_averageConsumptionValue_postedValidDoubleOnMutableLiveData() {
        doubleMutableLiveData.postValue(new FuelStat(4.5d,4.5d,0,0,0));

//        try {
//            testRule.drainTasks(3, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }

        onView(withId(R.id.average_consumption_value)).check(matches(withText("4.5")));
        onView(withId(R.id.driving_cost_value)).check(matches(withText("4.5")));
        onView(withId(R.id.total_distance_value)).check(matches(withText("0")));
        onView(withId(R.id.total_amount_value)).check(matches(withText("0")));
        onView(withId(R.id.total_consumption_value)).check(matches(withText("0")));

    }

    @Test
    public void shouldDisplay_averageConsumptionValue_postedNullOnMutableLiveData() {
        doubleMutableLiveData.postValue(null);

//        try {
//            testRule.drainTasks(3, TimeUnit.MILLISECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }

        onView(withId(R.id.average_consumption_value)).check(matches(withText("--")));
        onView(withId(R.id.driving_cost_value)).check(matches(withText("--")));
        onView(withId(R.id.total_distance_value)).check(matches(withText("--")));
        onView(withId(R.id.total_amount_value)).check(matches(withText("--")));
        onView(withId(R.id.total_consumption_value)).check(matches(withText("--")));
    }

}