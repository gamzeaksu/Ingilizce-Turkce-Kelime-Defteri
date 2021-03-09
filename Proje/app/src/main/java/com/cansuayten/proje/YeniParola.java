package com.cansuayten.proje;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class YeniParola extends AppCompatActivity {
    EditText email;
    Button btnGonder;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yeni_parola);
        email = (EditText) findViewById(R.id.mail);
        btnGonder = (Button) findViewById(R.id.yeniParola);

        mAuth = FirebaseAuth.getInstance();

        btnGonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();

                if(TextUtils.isEmpty(mail)){
                    Toast.makeText(getApplicationContext(),"E-mailinizi girin",Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.sendPasswordResetEmail(mail)
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(), "Parola yenileme linki mailinize gönderildi.", Toast.LENGTH_LONG).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(getApplicationContext(), "Mail gönderiminde hata oluştu.", Toast.LENGTH_LONG).show();
                            }
                        });
            }
        });


    }

}