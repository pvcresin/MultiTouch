package com.example.leica.multitouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

// http://pr.cei.uec.ac.jp/kobo2015/index.php?Android%2FTouch
public class MultiTouchView extends View {

    TextView tv;
    Paint paint = new Paint();

    int radius = 100;

    boolean touched;
    int type;
    float pressure;
    int pointer_count;

    static final int MAXPOINT = 10;
    int x[] = new int[MAXPOINT];
    int y[] = new int[MAXPOINT];
    int pointer_id[] = new int[MAXPOINT];

    public MultiTouchView(Context context, AttributeSet attrs) {
        super(context, attrs);

        for (int i = 0; i < MAXPOINT; i++) {
            x[i] = -999;
            y[i] = -999;
        }

        setBackgroundColor(Color.GRAY);
        paint.setTextSize(40);
    }

    public void setTextView(TextView _tv){
        tv = _tv;
    }

    @Override
    protected void onDraw(Canvas canvas) {  // = onResume loop
        super.onDraw(canvas);

        setBackgroundColor(Color.BLACK);

        if (touched) {
            for (int i = 0; i < pointer_count; i++) {
                paint.setStyle(Paint.Style.STROKE);
                paint.setARGB(255, 255, 255, 255);  // white line

                canvas.drawCircle(x[i], y[i], radius, paint);

                String s = "Order: " + i + ", ID: " + pointer_id[i] + ", X: " + x[i] + ", Y: " + y[i];
                canvas.drawText(s, x[i] - 300, y[i] - 2 * radius, paint);
            }
            touched = false;
        }

        //invalidate();
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);

        type = event.getActionMasked();
        pressure = event.getPressure();
        pointer_count = event.getPointerCount();

        touched = true;

        if (pointer_count == 1 && type == MotionEvent.ACTION_UP){ // all fingers released
            touched = false;
            pointer_count = 0;
            pressure = 0;
        }

        for (int i = 0; i < MAXPOINT; i++) {

            if (i < pointer_count) {
                x[i] = (int) event.getX(i);
                y[i] = (int) event.getY(i);
                pointer_id[i] = event.getPointerId(i);
            } else {
                x[i] = -999;
                y[i] = -999;
            }
        }


        // send process here

        String s = "TouchPoint:" + pointer_count + ",\nTouchX:" + x[0];

        for (int i = 1; i < MAXPOINT; i++) s += "_" + x[i];

        s += ",\nTouchY:" + y[0];

        for (int i = 1; i < MAXPOINT; i++) s += "_" + y[i];


        tv.setText(s);


        invalidate();   // refresh view = onDraw()

        return true;    // do not transmit touch event
    }

}