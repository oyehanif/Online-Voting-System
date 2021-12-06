package com.example.onlinevotingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CandidateDetailList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.candidate_detail_list);

        getSupportActionBar().hide();
    }
}