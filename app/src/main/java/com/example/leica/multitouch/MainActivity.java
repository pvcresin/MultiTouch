package com.example.leica.multitouch;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends Activity {

    String TAG = "Gesture";
    Context context;
    TextView tv;
    MultiTouchView mtv;
    GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        context = MainActivity.this;

        mtv = (MultiTouchView) findViewById(R.id.multi);
        tv = (TextView) findViewById(R.id.touchTv);
        mtv.setTextView(tv);

        //gestureDetector = new GestureDetector(gestureL);
    }

    /*

    @Override
    public boolean onTouchEvent(MotionEvent ev) {   // identify motion event
        gestureDetector.onTouchEvent(ev);

        return false;
    }

    GestureDetector.OnGestureListener gestureL =  new GestureDetector.SimpleOnGestureListener() {

        public boolean onDown(MotionEvent e) {  // touch
            Log.d(TAG, "called onDown()");
            return false;
        }

        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {  // flick = true
            Log.d(TAG, "called onFling()");
            return false;
        }

        public void onLongPress(MotionEvent e) {    // long tap
            Log.d(TAG, "called onLongPress()");
        }

        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) { // scroll = true
            Log.d(TAG, "called onScroll()");
            return false;
        }

        public void onShowPress(MotionEvent e) {    // touch except flick or scroll
            Log.d(TAG, "called onShowPress()");
        }

        public boolean onSingleTapUp(MotionEvent e) {   // single tap contain double tap
            Log.d(TAG, "called onSingleTapUp()");
            return false;
        }

        public boolean onDoubleTap (MotionEvent e){ // double tap
            Log.d(TAG, "called onDoubleTap()");
            return false;
        }

        public boolean onDoubleTapEvent(MotionEvent e) {    // tap, scroll or release ( after double tap )
            Log.d(TAG, "called onDoubleTapEvent()");
            return false;
        }

        public boolean onSingleTapConfirmed(MotionEvent e) {    // single tap except double tap
            Log.d(TAG, "called onSingleTapConfirmed()");
            return false;
        }
    };
    */
}

