package com.mani.fuellog.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentFactory;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.mani.fuellog.R;
import com.mani.fuellog.viewmodel.FuelLogViewModel;
import com.mani.fuellog.viewmodel.ViewModelUtil;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class DashboardFragmentTest {

    @Mock
    private FuelLogViewModel fuelLogViewModel;


    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);


        FragmentScenario<DashboardFragment> dashboardFragmentFragmentScenario = FragmentScenario.launchInContainer(DashboardFragment.class,null,new FragmentFactory(){
            @NonNull
            @Override
            public Fragment instantiate(@NonNull ClassLoader classLoader, @NonNull String className) {
                return DashboardFragment.newInstance(ViewModelUtil.createFor(fuelLogViewModel));
            }
        });


        dashboardFragmentFragmentScenario.onFragment(new FragmentScenario.FragmentAction<DashboardFragment>() {
            @Override
            public void perform(@NonNull DashboardFragment fragment) {
                fragment.getView().measure(0,0);
                fragment.getView().layout(0,0,100,1000);
            }
        });
    }


    @Test
    public void scrollToItemBelowFold_checkItsText() {
        onView(ViewMatchers.withId(R.id.recyclerView))
                .perform(RecyclerViewActions.scrollToPosition(3));

        String itemElementText = "Item3";
        onView(withText(itemElementText)).check(matches(isDisplayed()));
    }

    @Test
    public void itemInMiddleOfList_hasSpecialText() {
        // First, scroll to the view holder using the isInTheMiddle matcher.
        onView(ViewMatchers.withId(R.id.recyclerView))
                .perform(RecyclerViewActions.scrollToHolder(isInTheMiddle()));

        // Check that the item has the special text.
        String middleElementText ="Item5";
        onView(withText(middleElementText)).check(matches(isDisplayed()));
    }

    /**
     * Matches the {@link CustomAdapter.ViewHolder}s in the middle of the list.
     */
    private static Matcher<CustomAdapter.ViewHolder> isInTheMiddle() {
        return new TypeSafeMatcher<CustomAdapter.ViewHolder>() {
            @Override
            protected boolean matchesSafely(CustomAdapter.ViewHolder customHolder) {
                return customHolder.getIsInTheMiddle();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("item in the middle");
            }
        };
    }
}