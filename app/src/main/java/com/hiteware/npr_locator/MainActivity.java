package com.hiteware.npr_locator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private GPSTracker gps;
    private TextView mLatitudeText;
    private TextView mLongitudeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gps = new GPSTracker(MainActivity.this);
        mLatitudeText = (TextView) findViewById(R.id.mLatitudeText);
        mLongitudeText = (TextView) findViewById(R.id.mLongitudeText);
        // check if GPS enabled
        if(gps.canGetLocation()) {
            update();
        }
    }

    public void update() {
        mLatitudeText.setText(String.valueOf(gps.getLatitude()));
        mLongitudeText.setText(String.valueOf(gps.getLongitude()));
    }
}
