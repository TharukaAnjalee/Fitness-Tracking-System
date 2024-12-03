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

public class eightpage extends AppCompatActivity {

    EditText pckge,transaction,purchase;
    Button done;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eightpage);

        pckge = findViewById(R.id.purchaseinputId);
        transaction = findViewById(R.id.dateId);
        purchase = findViewById(R.id.purchasedateId);
        done = findViewById(R.id.done);

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p1 = pckge.getText().toString();
                String p2 = transaction.getText().toString();
                String p3 = purchase.getText().toString();



                if(TextUtils.isEmpty(p1)){
                    pckge.setError("Required");
                    return;
                }

                if(TextUtils.isEmpty(p2)){
                    transaction.setError("Required");
                    return;
                }

                if(TextUtils.isEmpty(p3)){
                    purchase.setError("Required");
                    return;
                }

                Map<String, Object> user = new HashMap<>();
                user.put("Package",p1);
                user.put("Transaction Date",p2);
                user.put("Purchase Date",p3);

                db.collection("Purchase Details")
                        .add(user)
                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(eightpage.this, "Successful Purchase", Toast.LENGTH_SHORT).show();
                                    pckge.setText("");
                                    transaction.setText("");
                                    purchase.setText("");

                                    Intent intent = new Intent(eightpage.this,ninthpage.class);
                                    startActivity(intent);
                                }
                                else {
                                    Toast.makeText(eightpage.this, "Try Again", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}