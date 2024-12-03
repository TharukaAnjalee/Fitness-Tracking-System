package com.example.fitnesstrackingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class thirdpage extends AppCompatActivity {

    Button masterBtn,eliteBtn,juniorBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdpage);

        masterBtn = findViewById(R.id.masterbtn);
        eliteBtn = findViewById(R.id.elitebtn);
        juniorBtn = findViewById(R.id.juniorbtn);

        masterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thirdpage.this,fourthpage.class);
                startActivity(intent);
            }
        });

        eliteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thirdpage.this, fourthpage.class);
                startActivity(intent);
            }
        });

        juniorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thirdpage.this, fourthpage.class);
                startActivity(intent);
            }
        });


    }
}