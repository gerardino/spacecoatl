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
import android.app.Activity;
import android.app.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Dashboard extends Fragment {
    //private OnItemSelectedListener listener;
    private final SimpleDateFormat _sdfWatchTime = new SimpleDateFormat("HH:mm");
    BroadcastReceiver _broadcastReceiver;
    private TextView _tvTime;

    NotificationRowGenerator nrg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dashboard,
                container, false);

        nrg = new NotificationRowGenerator(view.getContext(), _sdfWatchTime);

        _tvTime = (TextView)view.findViewById(R.id._tvTime);
        _tvTime.setText(_sdfWatchTime.format(new Date()));

        TableLayout tl = (TableLayout)(view.findViewById(R.id.notificationTable));
        tl.addView(nrg.getNotificationRow("Hello world", "This is a quick test to see if stuff can be created"));

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        _broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context ctx, Intent intent) {
                if (intent.getAction().compareTo(Intent.ACTION_TIME_TICK) == 0) {
                    _tvTime.setText(_sdfWatchTime.format(new Date()));
                }
            }
        };

        getActivity().registerReceiver(_broadcastReceiver, new IntentFilter(Intent.ACTION_TIME_TICK));

    }

    @Override
    public void onStop() {
        super.onStop();
        if (_broadcastReceiver != null)
            getActivity().unregisterReceiver(_broadcastReceiver);

    }
}
