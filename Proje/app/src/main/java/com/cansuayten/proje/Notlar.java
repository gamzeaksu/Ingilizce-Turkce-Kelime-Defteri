package com.cansuayten.proje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.List;

public class Notlar extends AppCompatActivity {
    private ListView NotListele;
    private Button btnEkle,btnGit;
    private EditText baslik,not;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notlar);
        NotListele = (ListView) findViewById(R.id.NotListele);
        btnEkle = (Button) findViewById(R.id.btnEkle);
        btnGit = (Button) findViewById(R.id.btnGit);
        baslik =(EditText) findViewById(R.id.txtBaslik);
        not =(EditText) findViewById(R.id.txtNot);
        Listele();

        btnEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VeriTabani vt =new VeriTabani(Notlar.this);
                vt.VeriEkle(baslik.getText().toString(),not.getText().toString());
                Toast.makeText(getApplicationContext(),"Eklendi.", Toast.LENGTH_LONG).show();
                Listele();
            }
        });
        btnGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GramerBilgi.class);
                startActivity(intent);
            }
        });
    }
    public void Listele()
    {
        VeriTabani vt = new VeriTabani(getApplicationContext());
        List<String> list = vt.VeriListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1,list);
        NotListele.setAdapter(adapter);
    }
}