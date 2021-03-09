package com.cansuayten.proje;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;




public class HesapOlustur extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;
    private Button btnOlustur;
    private ListView VeriListele;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        Button btnOlustur = (Button) findViewById(R.id.btnOlustur);

        EditText is = (EditText) findViewById(R.id.editTextTextPersonName4);
        EditText si = (EditText) findViewById(R.id.editTextTextPersonName3);
        EditText ki = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText ps1 = (EditText) findViewById(R.id.editTextTextPassword2);
        EditText mail = (EditText) findViewById(R.id.editTextTextEmailAddress);

        btnOlustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = is.getText().toString();
                String Surname = si.getText().toString();
                String Username = ki.getText().toString();
                String Password = ps1.getText().toString();
                String email = mail.getText().toString();
                //User user = new User(Name, Surname, Username, Password);
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(Name) || TextUtils.isEmpty(Surname) || TextUtils.isEmpty(Username)) {
                    Toast.makeText(getApplicationContext(), "Tüm alanları doldurunuz.", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(Password)) {
                    Toast.makeText(getApplicationContext(), "Tüm alanları doldurunuz.", Toast.LENGTH_SHORT).show();
                }
                if (Password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Parolanızı lütfen en az 6 kararkter yapınız.", Toast.LENGTH_SHORT).show();
                }

                mAuth.createUserWithEmailAndPassword(email, Password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    dbEkle(Name,Surname,Username,Password,email);
                                } else {
                                    Toast.makeText(getApplicationContext(), "E-mail ya da parolanız hatalı", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }

        });
    }
    public void dbEkle(String name, String surname,String username,String password, String mail)
    {
        HashMap<String,String> hm = new HashMap<String,String>();
        hm.put("name",name);
        hm.put("surname",surname);
        hm.put("username",username);
        hm.put("password",password);
        hm.put("mail",mail);
        db.collection("Users").document().set(hm).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                Toast.makeText(getApplicationContext(), "Başarılı Kayıt", Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), Anasayfa.class));
                finish();
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Hatalı Kayıt", Toast.LENGTH_LONG).show();
                    }
                });
    }
}


