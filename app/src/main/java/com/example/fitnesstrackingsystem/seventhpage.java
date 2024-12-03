package com.example.fitnesstrackingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class seventhpage extends AppCompatActivity {
    Button master,junior,elite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventhpage);

        master = findViewById(R.id.masterId);
        elite = findViewById(R.id.eliteId);
        junior = findViewById(R.id.juniorId);

        master.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(seventhpage.this,eightpage.class);
                startActivity(intent);
            }
        });

        elite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(seventhpage.this,eightpage.class);
                startActivity(intent);
            }
        });

        junior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(seventhpage.this,eightpage.class);
                startActivity(intent);
            }
        });


    }
}