package com.cansuayten.proje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KelimeKartlari extends AppCompatActivity {
private Button resimli,resimsiz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelime_kartlari);
        resimli = (Button) findViewById(R.id.btnResimli);
        resimsiz = (Button) findViewById(R.id.btnResimsiz);
        resimli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Kartlar.class);
                startActivity(intent);
            }
        });
        resimsiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), KelimeAlistirmalari.class);
                startActivity(intent);
            }
        });
    }

}