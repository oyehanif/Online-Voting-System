package com.example.onlinevotingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {

    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://online-voting-system-9d65b-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        getSupportActionBar().hide();

        final EditText phone=findViewById(R.id.login_phone);
        final EditText password = findViewById(R.id.login_password);
        final Button loginBtn = findViewById(R.id.loginBtn);
        final TextView registerNowBtn = findViewById(R.id.registerNowBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String phoneTxt = phone.getText().toString();
                final String passwordTxt = password.getText().toString();

                if (phoneTxt.isEmpty() || passwordTxt.isEmpty()){
                    Toast.makeText(Login.this, "Please Enter Your Phone Number Or Password", Toast.LENGTH_SHORT).show();
                }else {

                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            if (snapshot.hasChild(phoneTxt)){
                                final String getpassword = snapshot.child(phoneTxt).child("password").getValue(String.class);

                                if (getpassword.equals(passwordTxt)){
                                    Toast.makeText(Login.this, "Successfully login! ", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Login.this,HomeScreen.class));
                                    finish();
                                }
                                else{
                                    Toast.makeText(Login.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else {
                                Toast.makeText(Login.this, "Wrong Phone Number!", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });
        registerNowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });
    }
}