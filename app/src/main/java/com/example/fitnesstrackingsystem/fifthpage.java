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
import java.util.Objects;

public class fifthpage extends AppCompatActivity {

    EditText userId,create,update,category;
    Button ok;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifthpage);

        userId = findViewById(R.id.userId);
        create = findViewById(R.id.createId);
        update = findViewById(R.id.updateId);
        category = findViewById(R.id.selectId);
        ok = findViewById(R.id.okId);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = userId.getText().toString();
                String b = create.getText().toString();
                String c = update.getText().toString();
                String d = category.getText().toString();

                if(TextUtils.isEmpty(a)){
                    userId.setError("Id is required");
                    return;
                }

                if (TextUtils.isEmpty(b)){
                    create.setError("Create Id is required");
                    return;
                }

                if (TextUtils.isEmpty(c)){
                    update.setError("Create Id is required");
                    return;
                }

                if (TextUtils.isEmpty(d)){
                    category.setError("Create Id is required");
                    return;
                }

                Map<String, Object>  user = new HashMap<>();
                user.put("Category Id",a);
                user.put("Create Date",b);
                user.put("Update Date",c);
                user.put("Enter Category",d);
                
                db.collection("category_section")
                        .add(user)
                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(fifthpage.this, "Welldone", Toast.LENGTH_SHORT).show();
                                    userId.setText("");
                                    create.setText("");
                                    update.setText("");
                                    category.setText("");

                                    Intent intent = new Intent(fifthpage.this,sixthpage.class);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(fifthpage.this, "Try Again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

    }
}