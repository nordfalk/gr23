package com.example.thomas.gr23;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

public class Strikketeknikker extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_strikketeknikker);

        VideoView videoView = (VideoView)findViewById(R.id.videoView);

//        videoView.setVideoPath("");

        videoView.start();
    }
}



