package com.example.onlinevotingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

    }

        public void votigBtn(View view) {
            startActivity(new Intent(HomeScreen.this,PhoneAuthentication.class));
        }


    public void VotingCandidateDetailBtn(View view) {
        startActivity(new Intent(HomeScreen.this, CandidateDetailList.class));
    }

    public void demoBtn(View view) {
        startActivity(new Intent(HomeScreen.this,demoVideo.class));

    }
}
