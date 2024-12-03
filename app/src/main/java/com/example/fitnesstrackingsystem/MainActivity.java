package com.example.fitnesstrackingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    //private FirebaseFirestore db;
    Button continueBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        continueBtn = findViewById(R.id.buttoncontinue);

        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, secondpage.class);
                startActivity(intent);
            }
        });
    }
}