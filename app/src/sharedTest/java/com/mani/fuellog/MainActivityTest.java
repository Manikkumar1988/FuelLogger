package com.mani.fuellog;

import android.widget.TextView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.TestCase.assertEquals;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Test
    public void shouldHome() {
        ActivityScenario<MainActivity> mainActivityActivityScenario = ActivityScenario.launch(MainActivity.class);


        mainActivityActivityScenario.onActivity(new ActivityScenario.ActivityAction<MainActivity>() {
            @Override
            public void perform(MainActivity activity) {
                assertEquals(((TextView)activity.findViewById(R.id.message)).getText().toString(),"Home");

            }
        });

        onView(withId(R.id.message)).perform(click());


    }

}