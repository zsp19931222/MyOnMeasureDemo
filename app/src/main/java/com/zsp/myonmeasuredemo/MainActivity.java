package com.zsp.myonmeasuredemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String  assetPath="";
    private int a=0;
    private int b=1;
    private int max;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        max = (a<b) ? a : b;
        assetPath=assetPath==null?"":"123";
        Log.d(TAG, "onCreate: "+max);
        Log.d(TAG, "onCreate: "+assetPath);
    }
}
