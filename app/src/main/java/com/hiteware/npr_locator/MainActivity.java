package com.hiteware.npr_locator;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private GPSTracker gps;
    private TextView mLatitudeText;
    private TextView mLongitudeText;
    private TextView nearestStation;
    private NprLocation nprLocation = new NprLocation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gps = new GPSTracker(MainActivity.this);
        mLatitudeText = (TextView) findViewById(R.id.mLatitudeText);
        mLongitudeText = (TextView) findViewById(R.id.mLongitudeText);
        nearestStation = (TextView) findViewById(R.id.Nearest_Station);
        // check if GPS enabled
        if(gps.canGetLocation()) {
            update();
        }
    }

    public void update() {
        mLatitudeText.setText(String.valueOf(gps.getLatitude()));
        mLongitudeText.setText(String.valueOf(gps.getLongitude()));
        nearestStation.setText(nprLocation.getClosest(gps.getLatitude(),gps.getLongitude()));
        NotifyOnPhoneAndWearable();
    }

    private void NotifyOnPhoneAndWearable()
    {
        int notificationId = 1;

        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(getApplicationContext())
                        .setSmallIcon(R.mipmap.ic_launcher)
//                        .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000, 1000})
                        .setContentTitle("NprLocation")
                        .setContentText(nearestStation.getText())
                        .setDefaults(Notification.DEFAULT_ALL);

        NotificationManager notificationManager = (NotificationManager) getApplication().getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(notificationId, notificationBuilder.build());
    }
}
