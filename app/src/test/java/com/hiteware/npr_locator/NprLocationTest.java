package com.hiteware.npr_locator;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class NprLocationTest {

    @Test
    public void creatingAnEntryCanGetStationBackColumbus() {
        NprLocation nprLocation = new NprLocation();
        assertThat(nprLocation.getClosest(39.961176, -82.998794), is("FM 90.5 Columbus"));
    }

    @Test
    public void creatingAnEntryCanGetStationBackCincinati() {
        NprLocation nprLocation = new NprLocation();
        assertThat(nprLocation.getClosest(39.103118, -84.512020), is("FM 90.9, FM 91.7 Cincinnati"));
    }
}
