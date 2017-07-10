/*
Created by: Justin Clark
Company: VaughnX
Purpose: To block out external sound using white, brown, and pink noise.
To do:  -Increase duration of brown and pink noise files.
        -use seek slider as an in-app volume controller
 */
package com.vaughnx.vaugi.soundwall;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.media.MediaPlayer;

public class MainActivity extends AppCompatActivity {

    private SeekBar whiteVolumeSeekBar;
    private SeekBar pinkVolumeSeekBar;
    private SeekBar brownVolumeSeekBar;
    private int maxVolume;
    private int curVOlume;
    private MediaPlayer whiteNoiseMP;
    private MediaPlayer brownNoiseMP;
    private MediaPlayer pinkNoiseMP;
    private ToggleButton whiteNoiseToggle;
    private ToggleButton brownNoiseToggle;
    private ToggleButton pinkNoiseToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Sets up white, brown, and pink noise players. Uses toggle buttons to turn sound on
        //and off.
        whiteNoiseMP = MediaPlayer.create(MainActivity.this, R.raw.whitenoise);
        brownNoiseMP = MediaPlayer.create(MainActivity.this, R.raw.brownnoise);
        pinkNoiseMP = MediaPlayer.create(MainActivity.this, R.raw.pinknoise);
        whiteNoiseToggle = (ToggleButton) findViewById(R.id.whitenoisebutton);
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
        brownNoiseToggle = (ToggleButton) findViewById(R.id.brownnoisebutton);
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
        pinkNoiseToggle = (ToggleButton) findViewById(R.id.pinknoisebutton);
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
        //End of sound controller initializations

        //Start of control volume with sliders//
        try{
            whiteVolumeSeekBar = (SeekBar) findViewById(R.id.whiteVolumeSeekBar);
            whiteVolumeSeekBar.setMax(100);
            whiteVolumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                    float log1 = (float) (Math.log(50-progress)/Math.log(50));
                    whiteNoiseMP.setVolume(1-log1, 1-log1);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            pinkVolumeSeekBar.setProgress(25);
        } catch (Exception e){
            Log.e("Exception", e.getMessage());
        }
        try{
            pinkVolumeSeekBar = (SeekBar) findViewById(R.id.pinkVolumeSeekBar);
            pinkVolumeSeekBar.setMax(100);
            pinkVolumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                    float log1 = (float) (Math.log(50-progress)/Math.log(50));
                    pinkNoiseMP.setVolume(1-log1, 1-log1);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            pinkVolumeSeekBar.setProgress(25);
        } catch (Exception e){
            Log.e("Exception", e.getMessage());
        }
        try{
            brownVolumeSeekBar = (SeekBar) findViewById(R.id.brownVolumeSeekBar);
            brownVolumeSeekBar.setMax(50);
            brownVolumeSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                    float log1 = (float) (Math.log(50-progress)/Math.log(50));
                    brownNoiseMP.setVolume(1-log1, 1-log1);
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });
            brownVolumeSeekBar.setProgress(25);

        } catch (Exception e){
            Log.e("Exception", e.getMessage());
        }
        //end of volume controller
    }
}
