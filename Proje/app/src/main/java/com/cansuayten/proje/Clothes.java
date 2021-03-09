package com.cansuayten.proje;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Clothes extends AppCompatActivity {
    private int i;
    TextView txtKelime,txtAnlam;
    private Button btnCocukSonraki,btnCocukOnceki,btnAlistirmalariGor;
    private ImageView btnGorsel,btnSes;
    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer2;
    private MediaPlayer mediaPlayer3;
    private MediaPlayer mediaPlayer4;
    private MediaPlayer mediaPlayer5;
    private MediaPlayer mediaPlayer6;
    private MediaPlayer mediaPlayer7;
    private MediaPlayer mediaPlayer8;
    private MediaPlayer mediaPlayer9;
    String[] kelime = {"Dress", "Jeans", "Pajamas", "Pants", "Polo Shirt", "Shirt", "Shoes" ,"Skirt" ,"Socks" };
    String[] anlam = {"Elbise", "Kot", "Pijama", "Pantolon", "Polo Gömlek", "Gömlek", "Ayakkabı" ,"Etek" ,"Çorap" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothes);

        btnGorsel =(ImageView) findViewById(R.id.btnGorsel);
        btnSes =(ImageView) findViewById(R.id.btnSes);
        btnCocukSonraki = (Button) findViewById(R.id.btnCocukSonraki);
        btnCocukOnceki = (Button) findViewById(R.id.btnCocukOnceki);
        btnAlistirmalariGor = (Button) findViewById(R.id.btnAlistirmalariGor);
        txtKelime = (TextView) findViewById(R.id.txtKelime);
        txtAnlam = (TextView) findViewById(R.id.txtAnlam);
        i = 0;

        mediaPlayer1 = MediaPlayer.create(this, R.raw.dress);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.jeans);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.pajamas);
        mediaPlayer4 = MediaPlayer.create(this, R.raw.pants);
        mediaPlayer5 = MediaPlayer.create(this, R.raw.polo_shirt);
        mediaPlayer6 = MediaPlayer.create(this, R.raw.shirt);
        mediaPlayer7 = MediaPlayer.create(this, R.raw.shoes);
        mediaPlayer8 = MediaPlayer.create(this, R.raw.skirt);
        mediaPlayer9 = MediaPlayer.create(this, R.raw.socks);
        btnCocukOnceki.setVisibility(View.INVISIBLE);
        btnSes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0){
                    mediaPlayer1.start();
                }else if(i==1){
                    mediaPlayer2.start();
                }else if(i==2){
                    mediaPlayer3.start();
                }else if(i==3){
                    mediaPlayer4.start();
                }else if(i==4){
                    mediaPlayer5.start();
                }else if(i==5){
                    mediaPlayer6.start();;
                }else if(i==6){
                    mediaPlayer7.start();
                }else if(i==7){
                    mediaPlayer8.start();
                }else if(i==8){
                    mediaPlayer9.start();
                }
            }
        });
        btnAlistirmalariGor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAlistirmalariGor.setVisibility(View.INVISIBLE);
                btnGorsel.setBackgroundResource(R.drawable.dress);
                txtAnlam.setText("Meaning:" + anlam[0]);
                txtKelime.setText("Word: " + kelime[0]);
            }
        });
        btnCocukSonraki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnCocukOnceki.setVisibility(View.VISIBLE);
                i++;
                if (i == 1) {
                    btnGorsel.setBackgroundResource(R.drawable.jeans);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 2) {
                    btnGorsel.setBackgroundResource(R.drawable.pajamas);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 3) {
                    btnGorsel.setBackgroundResource(R.drawable.pants);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 4) {
                    btnGorsel.setBackgroundResource(R.drawable.polo_shirt);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 5) {
                    btnGorsel.setBackgroundResource(R.drawable.shirt);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 6) {
                    btnGorsel.setBackgroundResource(R.drawable.shoes);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 7) {
                    btnGorsel.setBackgroundResource(R.drawable.skirt);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 8) {
                    btnGorsel.setBackgroundResource(R.drawable.socks);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else
                {
                    btnGorsel.setBackgroundResource(R.drawable.bitti);
                    btnCocukSonraki.setVisibility(View.INVISIBLE);
                    btnSes.setVisibility(View.INVISIBLE);
                    txtAnlam.setText("");
                    txtKelime.setText("");
                }
            }
        });
        btnCocukOnceki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i--;
                txtAnlam.setText("Meaning:" + anlam[i]);
                txtKelime.setText("Word: " + kelime[i]);
                btnCocukSonraki.setVisibility(View.VISIBLE);
                btnSes.setVisibility(View.VISIBLE);
                if (i == 0) {
                    btnCocukOnceki.setVisibility(View.INVISIBLE);
                    btnGorsel.setBackgroundResource(R.drawable.dress);
                } else if (i == 1) {
                    btnGorsel.setBackgroundResource(R.drawable.jeans);
                } else if (i == 2) {
                    btnGorsel.setBackgroundResource(R.drawable.pajamas);
                } else if (i == 3) {
                    btnGorsel.setBackgroundResource(R.drawable.pants);
                } else if (i == 4) {
                    btnGorsel.setBackgroundResource(R.drawable.polo_shirt);
                } else if (i == 5) {
                    btnGorsel.setBackgroundResource(R.drawable.shirt);
                } else if (i == 6) {
                    btnGorsel.setBackgroundResource(R.drawable.shoes);
                } else if (i == 7) {
                    btnGorsel.setBackgroundResource(R.drawable.skirt);
                } else if (i == 8) {
                    btnGorsel.setBackgroundResource(R.drawable.socks);
                }if(i==9) {
                    i--;
                }
            }
        });
    }
}