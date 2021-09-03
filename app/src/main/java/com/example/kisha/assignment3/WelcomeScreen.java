package com.example.kisha.assignment3;

import android.app.LauncherActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.LauncherActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;


public class WelcomeScreen extends AppCompatActivity {

    private static int timeOut = 10000;
    boolean FLAG = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
       //set title
        this.setTitle("Find the NUKE");
        //set screen orientation
        setupLaunchButton();

        zoomAnimation();

       Timer timer = new Timer();
       timer.schedule(new TimerTask() {
           @Override
           public void run() {
                Intent menuScreen = new Intent(WelcomeScreen.this, MenuScreen.class);
                startActivity(menuScreen);
                finish();
           }

       }, timeOut);










    }
    //Skip button class

    private void setupLaunchButton(){
        Button welcomeImage = (Button) findViewById(R.id.skip);
        welcomeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent menuIntent = new Intent(WelcomeScreen.this, MenuScreen.class);
                startActivity(menuIntent);
                FLAG = false;
            }
        });
    }
    //animation for zooming welcome screen image
    private void zoomAnimation(){
      ImageView zoom =  (ImageView) findViewById(R.id.nukeImage);
      Animation nukeZoom = AnimationUtils.loadAnimation(this,R.anim.zoom_in_out);
      zoom.startAnimation(nukeZoom);

   }






}
