package com.example.spacecoatl.app;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;


public class Notification extends Activity {
    Button sync, clearLog;
    LinearLayout notificationListLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        notificationListLayout = (LinearLayout)findViewById(R.id.notificationListLayout);
        sync = (Button)findViewById(R.id.syncButton);
        clearLog = (Button)findViewById(R.id.clearLog);

        sync.setOnClickListener(new View.OnClickListener() {
            int i=0;

            @Override
            public void onClick(View view) {
                //
                LinearLayout element = (LinearLayout)getLayoutInflater().inflate(R.layout.notification_element,null);
                Resources res = getResources();
                ((TextView) element.findViewById(R.id.notificationText)).setText("i = " + i);
                ((ImageView)element.findViewById(R.id.notificationIcon)).setImageDrawable(res.getDrawable(R.drawable.medical_icon));
                notificationListLayout.addView(element, 0);
                i++;

            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.notification, menu);
        return true;
    }


}
