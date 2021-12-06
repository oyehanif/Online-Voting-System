package com.example.onlinevotingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.VideoView;

public class demoVideo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo);


        VideoView demo = findViewById(R.id.DemoVideo);
        demo.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.clip);
        demo.start();
    }
}