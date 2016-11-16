package com.hiteware.npr_locator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NprLocationTest {

    @Test
    public void creatingAnEntryCanGetStationBackWithDistance() {
        NprLocation nprLocation = new NprLocation();
        //Columbus WCBE-FM 90.5
        double latitude = 39.961176;
        double longitude = -82.998794;
        assertThat(nprLocation.getClosest(latitude, longitude), is("FM 90.5"));
    }
}
