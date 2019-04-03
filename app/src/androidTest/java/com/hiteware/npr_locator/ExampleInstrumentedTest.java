package com.hiteware.npr_locator;

import android.location.LocationManager;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void testGPS() {
        MockLocationProvider mock = new MockLocationProvider(LocationManager.GPS_PROVIDER, getContext());

        //Set test location
        mock.pushLocation(1.0, 2.0);

        onView(withId(R.id.mLatitudeText)).check(matches(withText(Double.toString(1.0))));
        onView(withId(R.id.mLongitudeText)).check(matches(withText(Double.toString(2.0))));

        mock.shutdown();
    }
}
