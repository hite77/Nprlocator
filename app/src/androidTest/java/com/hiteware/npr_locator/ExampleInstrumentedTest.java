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

//    @Before
//    public void initValidString() {
//        // Specify a valid string.
//        mStringToBetyped = "Espresso";
//    }

//    @Test
//    public void changeText_sameActivity() {
//        // Type text and then press the button.
//        onView(withId(R.id.editTextUserInput))
//                .perform(typeText(mStringToBetyped), closeSoftKeyboard());
//        onView(withId(R.id.changeTextBt)).perform(click());
//
//        // Check that the text was changed.
//        onView(withId(R.id.textToBeChanged))
//                .check(matches(withText(mStringToBetyped)));
//    }

    @Test
    public void testGPS() {
        MockLocationProvider mock = new MockLocationProvider(LocationManager.GPS_PROVIDER, getContext());

        //Set test location
        mock.pushLocation(1.0, 2.0);

//        LocationManager lm = (LocationManager) getContext().getSystemService(Context.LOCATION_SERVICE);

//        lm.setTestProviderEnabled(LocationManager.GPS_PROVIDER, true);
//        lm.setTestProviderStatus(LocationManager.GPS_PROVIDER,
//                LocationProvider.AVAILABLE,
//                null, System.currentTimeMillis());

//        Location location = new Location(LocationManager.GPS_PROVIDER);
//        location.setLatitude(1.0);
//        location.setLongitude(2.0);
//        location.setTime(System.currentTimeMillis());
//        lm.setTestProviderLocation(LocationManager.GPS_PROVIDER, location);

//        try {
//            Thread.sleep(2000);
//        } catch(InterruptedException e) {
//        }

        onView(withId(R.id.mLatitudeText)).check(matches(withText(Double.toString(1.0))));
        onView(withId(R.id.mLongitudeText)).check(matches(withText(Double.toString(2.0))));

        mock.shutdown();
//                .check(matches(withText(mStringToBetyped)));
//        String test_rs = "lon=" + location.getLongitude() + "\nlat="
//                + location.getLatitude();
//        String msg = "Location Succeeded";

//        assertEquals(msg, MainActivity..getText().toString(),
//                test_rs);
//        TextView mLatitudeText = (TextView) findViewById(R.id.mLatitudeText);
//        TextView mLongitudeText = (TextView) findViewById(R.id.mLongitudeText);
    }
}
