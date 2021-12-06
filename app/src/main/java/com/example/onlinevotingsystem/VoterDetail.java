package com.example.onlinevotingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VoterDetail extends AppCompatActivity {

    Button VoteBtn;

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://online-voting-system-9d65b-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voter_detail);

       // getSupportActionBar().hide();


        VoteBtn = findViewById(R.id.voteBtn);
        final EditText aadarnumber = findViewById(R.id.Aadarnumber);
        final EditText Partyname = findViewById(R.id.partyName);
        final EditText voterNumber = findViewById(R.id.voterNumber);

        VoteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String partynametxt = Partyname.getText().toString();
                final String aadartxt = aadarnumber.getText().toString();
                final String voterNumtxt = voterNumber.getText().toString();

                if (partynametxt.isEmpty() || aadartxt.isEmpty() || voterNumtxt.isEmpty()){
                    Toast.makeText(VoterDetail.this, "Please Fill All Fileds", Toast.LENGTH_SHORT).show();
                }
                else if (aadartxt.length() <= 11 || aadartxt.length() >=13){
                    Toast.makeText(getApplicationContext(), "Please enter a Valid AADHAR Card!!", Toast.LENGTH_SHORT).show();
                }else if (voterNumtxt.length() <=9 || voterNumtxt.length() >=11){
                    Toast.makeText(getApplicationContext(), "Please Enter A Valid 10 Number Only!!", Toast.LENGTH_SHORT).show();
                }
                else {

                    databaseReference.child("Votes").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(aadartxt)){
                                Toast.makeText(VoterDetail.this, "AADHAR is Already registed", Toast.LENGTH_SHORT).show();
                            }

                            else {

                                databaseReference.child("Votes").child(aadartxt).child("Vote").setValue(partynametxt);
                                databaseReference.child("Votes").child(aadartxt).child("email").setValue(voterNumtxt);

                                Toast.makeText(VoterDetail.this, "Vote Successfully !!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(VoterDetail.this,HomeScreen.class));

                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }
            }
        });



    }
}