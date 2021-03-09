package com.cansuayten.proje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Giris extends AppCompatActivity {
    private EditText email,sifre;
    private TextView hesapOlustur,sifremiUnuttum,adminGirisi;
    private Button btnGiris;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        mAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.editTextTextPersonName);
        sifre = (EditText) findViewById(R.id.editTextTextPassword);
        hesapOlustur = (TextView) findViewById(R.id.textView);
        sifremiUnuttum = (TextView) findViewById(R.id.textView2);
        adminGirisi = (TextView) findViewById(R.id.txtAdmin);
        btnGiris = (Button) findViewById(R.id.btnGiris);

        if(mAuth.getCurrentUser() !=null)
        {
            Intent intent = new Intent(getApplicationContext(), Anasayfa.class);
            startActivity(intent);
            finish();
        }


        btnGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString();
                String password = sifre.getText().toString();
                mAuth.signInWithEmailAndPassword(mail,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            String guncelKullanici =mAuth.getCurrentUser().getEmail().toString();
                            Toast.makeText(getApplicationContext(), "Hoşgeldiniz:"+guncelKullanici, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Anasayfa.class);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Bilgileriniz hatalı", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        hesapOlustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HesapOlustur.class);
                startActivity(intent);
            }
        });
        adminGirisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminGirisi.class);
                startActivity(intent);
            }
        });

        sifremiUnuttum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), YeniParola.class);
                startActivity(intent);
            }
        });

    }
}