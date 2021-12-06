package com.example.onlinevotingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VotingScreen extends AppCompatActivity {

    Button VoteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voting_screen);

        getSupportActionBar().hide();

        VoteBtn = findViewById(R.id.vote);



        //bjp
        VoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VotingScreen.this,VoterDetail.class));
            }
        });


    }
}