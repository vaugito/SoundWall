package com.vaughnx.soundwall;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;


/*
Created by: Justin Clark
Company: VaughnX
Purpose: To block out external sound using white, brown, and pink noise.
To do:  -Increase duration of brown and pink noise files.
        -use seek slider as an in-app volume controller
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    final MediaPlayer whiteNoiseMP = MediaPlayer.create(this, R.raw.whitenoise);
    final MediaPlayer brownNoiseMP = MediaPlayer.create(this, R.raw.brownnoise);
    final MediaPlayer pinkNoiseMP = MediaPlayer.create(this, R.raw.pinknoise);
    ToggleButton whiteNoiseToggle = (ToggleButton) findViewById(R.id.whiteToggleButton);
    whiteNoiseToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                // The toggle is enabled
                whiteNoiseMP.start();
            } else {
                // The toggle is disabled
                whiteNoiseMP.pause();
            }
        }
    });
    ToggleButton brownNoiseToggle = (ToggleButton) findViewById(R.id.brownToggleButton);
    brownNoiseToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                // The toggle is enabled
                brownNoiseMP.start();
            } else {
                // The toggle is disabled
                brownNoiseMP.pause();
            }
        }
    });
        ToggleButton pinkNoiseToggle = (ToggleButton) findViewById(R.id.pinkNoiseButton);
        pinkNoiseToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // The toggle is enabled
                    pinkNoiseMP.start();
                } else {
                    // The toggle is disabled
                    pinkNoiseMP.pause();
                }
            }
        });
}}
