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

public class secondpage extends AppCompatActivity {

    EditText uname, mail, pw;
    Button login;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);

        uname = findViewById(R.id.usertext);
        mail = findViewById(R.id.emailtext);
        pw = findViewById(R.id.pwtext);

        login = findViewById(R.id.loginbtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = uname.getText().toString();
                String email = mail.getText().toString();
                String password = pw.getText().toString();

                if (TextUtils.isEmpty(name)) {
                    uname.setError("Name is Required");
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    mail.setError("Email is Required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    pw.setError("Password is Required");
                    return;
                }

                Map<String, Object> user = new HashMap<>();
                user.put("Name", name);
                user.put("Email", email);
                user.put("Password", password);

                db.collection("Login Details")
                        .add(user)
                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(secondpage.this, "Login successfully!", Toast.LENGTH_SHORT).show();
                                    uname.setText("");
                                    mail.setText("");
                                    pw.setText("");

                                    Intent intent = new Intent(secondpage.this,thirdpage.class);
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(secondpage.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}