package com.cansuayten.proje;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Weather extends AppCompatActivity {
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
    String[] kelime = {"Cloudy", "Cold", "Cool", "Hot", "Raining", "Snowing", "Sunny", "Warm", "Windy"};
    String[] anlam = {"Bulutlu", "Soğuk", "Soğuk", "Sıcak", "Yağmur", "Karlı", "Güneşli", "Ilık", "Rüzgarlı"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        btnGorsel =(ImageView) findViewById(R.id.btnGorsel);
        btnSes =(ImageView) findViewById(R.id.btnSes);
        btnCocukSonraki = (Button) findViewById(R.id.btnCocukSonraki);
        btnCocukOnceki = (Button) findViewById(R.id.btnCocukOnceki);
        btnAlistirmalariGor = (Button) findViewById(R.id.btnAlistirmalariGor);
        txtKelime = (TextView) findViewById(R.id.txtKelime);
        txtAnlam = (TextView) findViewById(R.id.txtAnlam);
        i = 0;

        mediaPlayer1 = MediaPlayer.create(this, R.raw.cloudy);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.cold);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.cool);
        mediaPlayer4 = MediaPlayer.create(this, R.raw.hot);
        mediaPlayer5 = MediaPlayer.create(this, R.raw.raining);
        mediaPlayer6 = MediaPlayer.create(this, R.raw.snowing);
        mediaPlayer7 = MediaPlayer.create(this, R.raw.sunny);
        mediaPlayer8 = MediaPlayer.create(this, R.raw.warm);
        mediaPlayer9 = MediaPlayer.create(this, R.raw.windy);
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
                btnGorsel.setBackgroundResource(R.drawable.cloudy);
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
                    btnGorsel.setBackgroundResource(R.drawable.cold);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 2) {
                    btnGorsel.setBackgroundResource(R.drawable.cool);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 3) {
                    btnGorsel.setBackgroundResource(R.drawable.hot);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 4) {
                    btnGorsel.setBackgroundResource(R.drawable.raining);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 5) {
                    btnGorsel.setBackgroundResource(R.drawable.snowing);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 6) {
                    btnGorsel.setBackgroundResource(R.drawable.sunny);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 7) {
                    btnGorsel.setBackgroundResource(R.drawable.warm);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 8) {
                    btnGorsel.setBackgroundResource(R.drawable.windy);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                }else
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
                    btnGorsel.setBackgroundResource(R.drawable.cloudy);
                } else if (i == 1) {
                    btnGorsel.setBackgroundResource(R.drawable.cold);
                } else if (i == 2) {
                    btnGorsel.setBackgroundResource(R.drawable.cool);
                } else if (i == 3) {
                    btnGorsel.setBackgroundResource(R.drawable.hot);
                } else if (i == 4) {
                    btnGorsel.setBackgroundResource(R.drawable.raining);
                } else if (i == 5) {
                    btnGorsel.setBackgroundResource(R.drawable.snowing);
                } else if (i == 6) {
                    btnGorsel.setBackgroundResource(R.drawable.sunny);
                } else if (i == 7) {
                    btnGorsel.setBackgroundResource(R.drawable.warm);
                } else if (i == 8) {
                    btnGorsel.setBackgroundResource(R.drawable.windy);
                }
                if(i==9) {
                    i--;
                }
            }
        });
    }
}