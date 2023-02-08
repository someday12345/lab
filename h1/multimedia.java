package com.example.media;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button play, forward, rewind, pause, stop, reset,backward;
    MediaPlayer mediaPlayer ;
    int starttime = 0 ; // startime is 0s
    int stopttime = 0; // stoptime is 0s by default
    int forwardtime = 5000 ; // 5s for forward
    int backwardtime = 5000 ; // 5s for backwardtime
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=findViewById(R.id.play);
        pause=findViewById(R.id.pause);
        forward=findViewById(R.id.forward);
        backward=findViewById(R.id.rewind);
        reset=findViewById(R.id.restart);
        stop=findViewById(R.id.stop);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Playing Media now",
                        Toast.LENGTH_SHORT).show();
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.song) ;
                mediaPlayer.start();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.seekTo(starttime);
                mediaPlayer.start();
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentpos = mediaPlayer.getCurrentPosition() ;
                if((currentpos+forwardtime) <= (stopttime =mediaPlayer.getDuration())){
                    mediaPlayer.seekTo(currentpos+forwardtime);
                }
            }
        });

        backward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentpos = mediaPlayer.getCurrentPosition() ;
                if((currentpos-backwardtime) <= (stopttime =mediaPlayer.getDuration())){
                    mediaPlayer.seekTo(currentpos-backwardtime);
                }
            }
        });
    }


}
