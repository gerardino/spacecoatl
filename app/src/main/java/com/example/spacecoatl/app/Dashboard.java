package com.example.spacecoatl.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.spacecoatl.app.components.NotificationRowGenerator;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Dashboard extends Activity {

    private final SimpleDateFormat _sdfWatchTime = new SimpleDateFormat("HH:mm");
    BroadcastReceiver _broadcastReceiver;
    private TextView _tvTime;

    NotificationRowGenerator nrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        nrg = new NotificationRowGenerator(this.getApplicationContext(), _sdfWatchTime);

        _tvTime = (TextView)findViewById(R.id._tvTime);
        _tvTime.setText(_sdfWatchTime.format(new Date()));

        TableLayout tl = (TableLayout)(findViewById(R.id.notificationTable));
        tl.addView(nrg.getNotificationRow("Hello world", "This is a quick test to see if stuff can be created"));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart()
    {
        super.onStart();
        _broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context ctx, Intent intent)
            {
                if (intent.getAction().compareTo(Intent.ACTION_TIME_TICK) == 0) {
                    _tvTime.setText(_sdfWatchTime.format(new Date()));
                }
            }
        };

        registerReceiver(_broadcastReceiver, new IntentFilter(Intent.ACTION_TIME_TICK));
    }

    @Override
    public void onStop()
    {
        super.onStop();
        if (_broadcastReceiver != null)
            unregisterReceiver(_broadcastReceiver);
    }

}
