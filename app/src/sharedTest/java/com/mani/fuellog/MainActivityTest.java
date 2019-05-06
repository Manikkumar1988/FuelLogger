package com.mani.fuellog;

import android.widget.TextView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.TestCase.assertEquals;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    ActivityScenario<MainActivity> mainActivityActivityScenario;

    @Before
    public void setup() {
         mainActivityActivityScenario = ActivityScenario.launch(MainActivity.class);

    }

    @Test
    public void shouldHome() {
        mainActivityActivityScenario.onActivity(new ActivityScenario.ActivityAction<MainActivity>() {
            @Override
            public void perform(MainActivity activity) {
                assertEquals(((TextView)activity.findViewById(R.id.message)).getText().toString(),"Home");

            }
        });
    }


    @Test
    public void shouldDashboard() {
        onView(withId(R.id.navigation_dashboard)).perform(click());

        onView(withId(R.id.message)).check(matches(withText("Dashboard")));
    }

}