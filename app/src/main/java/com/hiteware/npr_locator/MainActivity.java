package com.hiteware.npr_locator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private GPSTracker gps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gps = new GPSTracker(MainActivity.this);

        // check if GPS enabled
        if(gps.canGetLocation()) {

            TextView mLatitudeText = (TextView) findViewById(R.id.mLatitudeText);
            TextView mLongitudeText = (TextView) findViewById(R.id.mLongitudeText);


            mLatitudeText.setText(String.valueOf(gps.getLatitude()));
            mLongitudeText.setText(String.valueOf(gps.getLongitude()));
        }
    }
}
