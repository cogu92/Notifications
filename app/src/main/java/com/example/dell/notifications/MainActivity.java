package com.example.dell.notifications;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnCustom = (Button) findViewById(R.id.buttonToCustomNotify);
        btnCustom.setOnClickListener(this);
        final Button btnNotify = (Button) findViewById(R.id.buttonToNotify);
        btnNotify.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonToCustomNotify:
                Log.i(MainActivity.TAG,"buttonToCustomNotify Click" );
                break;
            case R.id.buttonToNotify:
                Log.i(MainActivity.TAG,"buttonToNotify Click" );
                break;
            default:
                Log.v(MainActivity.TAG,"Click item not set");
        }
    }
}
