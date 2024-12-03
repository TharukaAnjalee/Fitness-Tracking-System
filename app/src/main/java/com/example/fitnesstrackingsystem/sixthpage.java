package com.example.fitnesstrackingsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class sixthpage extends AppCompatActivity {

    EditText name,dob,gender,weight,contact,country;
    Button next;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixthpage);

        name = findViewById(R.id.answer1);
        dob = findViewById(R.id.answer2);
        gender = findViewById(R.id.answer3);
        weight = findViewById(R.id.answer4);
        contact = findViewById(R.id.answer5);
        country = findViewById(R.id.answer6);
        next = findViewById(R.id.nextBtn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String un = name.getText().toString();
                String udob = dob.getText().toString();
                String ugender = gender.getText().toString();
                String uweight = weight.getText().toString();
                String ucountry = country.getText().toString();

                if(TextUtils.isEmpty(un)){
                    name.setError("Required");
                    return;
                }

                if(TextUtils.isEmpty(udob)){
                    dob.setError("Required");
                    return;
                }

                if(TextUtils.isEmpty(ugender)){
                    gender.setError("Required");
                    return;
                }

                if(TextUtils.isEmpty(uweight)){
                    weight.setError("Required");
                    return;
                }

                if(TextUtils.isEmpty(ucountry)){
                    country.setError("Required");
                    return;
                }

                Map<String,Object> user = new HashMap<>();
                user.put("User Name",un);
                user.put("Date Of Birth",udob);
                user.put("Gender",ugender);
                user.put("Weight",uweight);
                user.put("Country",ucountry);

                db.collection("User Details")
                        .add(user)
                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if (task.isSuccessful()){
                                Toast.makeText(sixthpage.this, "Success", Toast.LENGTH_SHORT).show();
                                name.setText("");
                                dob.setText("");
                                gender.setText("");
                                weight.setText("");
                                country.setText("");

                                    Intent intent = new Intent(sixthpage.this,seventhpage.class);
                                    startActivity(intent);
                            }
                                else {
                                    Toast.makeText(sixthpage.this, "Fail", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}