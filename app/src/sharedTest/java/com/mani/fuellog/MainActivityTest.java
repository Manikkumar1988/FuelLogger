package com.mani.fuellog;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.not;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    ActivityScenario<MainActivity> mainActivityActivityScenario;

    @Before
    public void setup() {
         mainActivityActivityScenario = ActivityScenario.launch(MainActivity.class);

    }

    @Test
    public void shouldDisplayHomeOnLaunch() {
        onView(withId(R.id.home_root_layout)).check(matches(isDisplayed()));
    }


    @Test
    public void shouldNotDisplayDashboardOnLaunch() {
        onView(withId(R.id.dashboard_root_layout)).check(matches(not(isDisplayed())));
    }



    @Test
    public void shouldDisplayDashboardOnDashboardClick() {
        onView(withId(R.id.navigation_dashboard)).perform(click());

        onView(withId(R.id.dashboard_root_layout)).check(matches(isDisplayed()));

    }

    @Test
    public void shouldNotDisplayHomeOnDashboardClick() {
        onView(withId(R.id.navigation_dashboard)).perform(click());

        onView(withId(R.id.home_root_layout)).check(matches(not(isDisplayed())));

    }

}