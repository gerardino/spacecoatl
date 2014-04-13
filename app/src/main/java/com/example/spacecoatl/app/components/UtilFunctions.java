package com.example.spacecoatl.app.components;

import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.view.View;

/**
 * Created by gerardino on 4/13/14.
 */
public class UtilFunctions {

    private static final float[] colorMatrix_Negative = {
            -1.0f, 0, 0, 0, 255, //red
            0, -1.0f, 0, 0, 255, //green
            0, 0, -1.0f, 0, 255, //blue
            0, 0, 0, 1.0f, 0 //alpha
    };

    public static Drawable InvertDrawable(Drawable d){
        //To generate negative image
        Paint MyPaint_Normal = new Paint();
        Paint MyPaint_Negative = new Paint();
        ColorFilter colorFilter_Negative = new ColorMatrixColorFilter(colorMatrix_Negative);

        d.setColorFilter(colorFilter_Negative);

        return d;
    }

}
