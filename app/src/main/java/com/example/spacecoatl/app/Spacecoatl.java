package com.example.spacecoatl.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;


public class Spacecoatl extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spacecoatl);

        Button buttonF1 = (Button) findViewById(R.id.actionF1);
        buttonF1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification mRigthFragment = new Notification();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.activities, mRigthFragment);
                ft.commit();
            }
        });

        Button buttonF2 = (Button) findViewById(R.id.actionF2);
        buttonF2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View fragment = findViewById(R.id.activities);
                ScrollView sv = (ScrollView) fragment.findViewById(R.id.fragmentScroll);
                sv.scrollTo(0, sv.getTop());


            }
        });

        Button buttonF3 = (Button) findViewById(R.id.actionF3);
        buttonF3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View fragment = findViewById(R.id.activities);
                ScrollView sv = (ScrollView) fragment.findViewById(R.id.fragmentScroll);
                sv.scrollTo(0, sv.getBottom());

            }
        });

        /*Button buttonF4L = (Button) findViewById(R.id.actionF4);
        buttonF4L.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                View fragment = findViewById(R.id.activities);
                Notification mRigthFragment = new Notification();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();

                ft.replace(R.id.activities, mRigthFragment);
                ft.commit();
                return true;
            }
        });*/
    }
}