package com.example.spacecoatl.app.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.spacecoatl.app.R;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gerardino on 4/12/14.
 */
public class NotificationRowGenerator {

    Context context;
    SimpleDateFormat sdf;


    public NotificationRowGenerator(Context context, SimpleDateFormat sdf){
        this.context = context;
        this.sdf = sdf;
    }

    public TableRow getNotificationRow(String title, String text, Date datetime, Integer imageAsset) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );

        TableRow row = (TableRow)inflater.inflate( R.layout.component_notification_row, null );

        ((TextView)(row.findViewById(R.id.notificationTitle))).setText(title);
        ((TextView)(row.findViewById(R.id.notificationText))).setText(text);
        if (datetime != null){
            ((TextView)(row.findViewById(R.id.notificationTime))).setText(sdf.format(datetime));
        }
        if (imageAsset != null){
            Drawable d =row.getResources().getDrawable(imageAsset);
            ((ImageView) (row.findViewById(R.id.image_badge))).setImageDrawable(UtilFunctions.InvertDrawable(d));
        }

        return row;
    }

    public TableRow getNotificationRow(String title, String text, Date datetime) {
        return getNotificationRow(title, text, datetime, null);
    }

        public TableRow getNotificationRow(String title, String text){
        return getNotificationRow(title, text, null, null);
    }
}
