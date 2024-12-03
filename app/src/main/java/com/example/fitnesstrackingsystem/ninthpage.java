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

public class ninthpage extends AppCompatActivity {

    EditText cardno,holder,expire,cvv;
    Button process;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ninthpage);

        cardno = findViewById(R.id.entercardId);
        holder = findViewById(R.id.holderId);
        expire = findViewById(R.id.expiryId);
        cvv = findViewById(R.id.cvvId);
        process = findViewById(R.id.proceedId);

        process.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String r = cardno.getText().toString();
                String s = holder.getText().toString();
                String t = expire.getText().toString();
                String u = cvv.getText().toString();



                if (TextUtils.isEmpty(r)) {
                    cardno.setError("Card Number is Required");
                    return;
                }

                if (TextUtils.isEmpty(s)) {
                    holder.setError("Card Holder Name is Required");
                    return;
                }

                if (TextUtils.isEmpty(t)) {
                    expire.setError("Expire Date is Required");
                    return;
                }

                if (TextUtils.isEmpty(u)) {
                    cvv.setError("CVV is Required");
                    return;
                }

                Map<String, Object> user = new HashMap<>();
                user.put("Card Number",r);
                user.put("Holder Name",s);
                user.put("Expire Date",t);
                user.put("CVV",u);

                db.collection("Payment Details")
                        .add(user)
                        .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(ninthpage.this, "Great Job", Toast.LENGTH_SHORT).show();
                                    cardno.setText("");
                                    holder.setText("");
                                    expire.setText("");
                                    cvv.setText("");

                                    Intent intent = new Intent(ninthpage.this,tenpage.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(ninthpage.this, "Try Again"+  task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}