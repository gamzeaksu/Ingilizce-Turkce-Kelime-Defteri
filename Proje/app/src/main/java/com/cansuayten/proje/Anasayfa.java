package com.cansuayten.proje;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Anasayfa extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Button btnAra,btnCalis,btnYaris;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);
        mAuth = FirebaseAuth.getInstance();

        btnAra = (Button) findViewById(R.id.btnAra);
        btnCalis=(Button) findViewById(R.id.btnCalis);
        btnYaris= (Button) findViewById(R.id.btnYaris);
        btnAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AraYeni.class);
                startActivity(intent);
            }
        });
        btnCalis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Calis.class);
                startActivity(intent);
            }
        });
        btnYaris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Yarisma.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mn = getMenuInflater();
        mn.inflate(R.menu.secenekler_menusu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.istek_ve_sikayet)
        {
            Intent intent = new Intent(getApplicationContext(), IstekVeSikayet.class);
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.cikis_yap)
        {
            mAuth.signOut();
            Intent intent = new Intent(getApplicationContext(), Giris.class);
            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}