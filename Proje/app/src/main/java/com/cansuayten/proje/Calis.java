package com.cansuayten.proje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Calis extends AppCompatActivity {
    private Button btnListeler,btnNotlar,btnKelimeKartlari,btnCoktanSecmeli,btnDinlemePratik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calis);

        btnListeler = (Button) findViewById(R.id.btnListeler);
        btnNotlar = (Button) findViewById(R.id.btnNotlar);
        btnKelimeKartlari = (Button) findViewById(R.id.btnKelimeKartlari);
        btnCoktanSecmeli = (Button) findViewById(R.id.btnCoktanSecmeli);
        btnDinlemePratik = (Button) findViewById(R.id.btnDinlemePratik);

        btnListeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListeYeni.class);
                startActivity(intent);
            }
        });
        btnNotlar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Notlar.class);
                startActivity(intent);
            }
        });
        btnCoktanSecmeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CoktanSecmeli_Yeni.class);
                startActivity(intent);
            }
        });
        btnKelimeKartlari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), KelimeKartlari.class);
                startActivity(intent);
            }
        });

        btnDinlemePratik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DinlemePratik.class);
                startActivity(intent);
            }
        });

    }

}