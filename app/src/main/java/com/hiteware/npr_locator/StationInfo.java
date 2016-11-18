package com.hiteware.npr_locator;

/**
 * Created on 11/16/16.
 */
public class StationInfo {
    private final double latitude;
    private final double longitude;
    private final String stationId;

    public StationInfo(String stationId, double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.stationId = stationId;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getStationId() {
        return stationId;
    }
}
