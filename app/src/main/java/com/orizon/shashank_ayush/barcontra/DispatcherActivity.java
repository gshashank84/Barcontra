package com.orizon.shashank_ayush.barcontra;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import com.orizon.shashank_ayush.barcontra.breakout.BreakoutActivity;

public class DispatcherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatcher);


        Class<?> activityClass;

        try {
            SharedPreferences prefs = getSharedPreferences("X", MODE_PRIVATE);
            activityClass = Class.forName(
                    prefs.getString("lastActivity", StartActivity.class.getName()));
        } catch(ClassNotFoundException ex) {
            activityClass = StartActivity.class;
        }

        if(activityClass == BreakoutActivity.class){
            //Open Trackerservice if Game is opened
            startActivity(new Intent(this, MainActivity.class));
        }

        else{
            startActivity(new Intent(this, activityClass));
        }
    }
}
