package com.hiteware.npr_locator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 11/15/16.
 */
public class NprLocation {


    List<StationInfo> stations = new ArrayList<StationInfo>();

    NprLocation() {
        stations.add(new StationInfo(39.103118, -84.512020,"FM 90.9, FM 91.7 Cincinnati"));
        stations.add(new StationInfo(39.961176, -82.998794,"FM 90.5 Columbus"));
    }

    public String getClosest(double latitude, double longitude) {
        double closestDistance = calculateDistance(stations.get(0), latitude, longitude);
        String result=stations.get(0).getStationId();
        for (StationInfo element : stations) {
            if (calculateDistance(element, latitude, longitude) < closestDistance)
            {
                closestDistance = calculateDistance(element, latitude, longitude);
                result = element.getStationId();
            }
        }
        return result;
    }
    private double calculateDistance(StationInfo stationInfo, double latitude, double longitude) {
        latitude = Math.toRadians(latitude);
        longitude = Math.toRadians(longitude);

        return Math.toDegrees(
                Math.acos(Math.sin(latitude)*
                Math.sin(Math.toRadians(stationInfo.getLatitude()))
                +Math.cos(latitude)*
                Math.cos(Math.toRadians(stationInfo.getLatitude()))*
                Math.cos(Math.abs(longitude-Math.toRadians(stationInfo.getLongitude())))));
    }
}
