package com.cansuayten.proje;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Fruits extends AppCompatActivity {
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
    private MediaPlayer mediaPlayer10;
    private MediaPlayer mediaPlayer11;
    String[] kelime = {"Apple", "Blueberry", "Cherry", "Grapes", "Melon", "Orange", "Peach", "Pear" ,"Pineapple" ,"Strawberry","Watermelon" };
    String[] anlam = {"Elma", "Yaban Mersini", "Kiraz", "Üzüm", "Kavun", "Portakal", "Şeftali", "Armut" ,"Ananas" ,"Çilek","Karpuz" };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
        btnGorsel =(ImageView) findViewById(R.id.btnGorsel);
        btnSes =(ImageView) findViewById(R.id.btnSes);
        btnCocukSonraki = (Button) findViewById(R.id.btnCocukSonraki);
        btnCocukOnceki = (Button) findViewById(R.id.btnCocukOnceki);
        btnAlistirmalariGor = (Button) findViewById(R.id.btnAlistirmalariGor);
        txtKelime = (TextView) findViewById(R.id.txtKelime);
        txtAnlam = (TextView) findViewById(R.id.txtAnlam);
        i = 0;

        mediaPlayer1 = MediaPlayer.create(this, R.raw.apple);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.blueberry);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.cherry);
        mediaPlayer4 = MediaPlayer.create(this, R.raw.grapes);
        mediaPlayer5 = MediaPlayer.create(this, R.raw.melon);
        mediaPlayer6 = MediaPlayer.create(this, R.raw.orange_f);
        mediaPlayer7 = MediaPlayer.create(this, R.raw.peach);
        mediaPlayer8 = MediaPlayer.create(this, R.raw.pear);
        mediaPlayer9 = MediaPlayer.create(this, R.raw.pineapple);
        mediaPlayer10 = MediaPlayer.create(this, R.raw.strawberry);
        mediaPlayer11 = MediaPlayer.create(this, R.raw.watermelon);
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
                }else if(i==9){
                    mediaPlayer10.start();
                }else if(i==10){
                    mediaPlayer11.start();
                }
            }
        });
        btnAlistirmalariGor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAlistirmalariGor.setVisibility(View.INVISIBLE);
                btnGorsel.setBackgroundResource(R.drawable.apple);
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
                    btnGorsel.setBackgroundResource(R.drawable.blueberry);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 2) {
                    btnGorsel.setBackgroundResource(R.drawable.cherry);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 3) {
                    btnGorsel.setBackgroundResource(R.drawable.grapes);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 4) {
                    btnGorsel.setBackgroundResource(R.drawable.melon);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 5) {
                    btnGorsel.setBackgroundResource(R.drawable.orange_f);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 6) {
                    btnGorsel.setBackgroundResource(R.drawable.peach);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 7) {
                    btnGorsel.setBackgroundResource(R.drawable.pear);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 8) {
                    btnGorsel.setBackgroundResource(R.drawable.pineapple);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 9) {
                    btnGorsel.setBackgroundResource(R.drawable.strawberry);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                }else if (i == 10) {
                    btnGorsel.setBackgroundResource(R.drawable.watermelon);
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
                    btnGorsel.setBackgroundResource(R.drawable.apple);
                } else if (i == 1) {
                    btnGorsel.setBackgroundResource(R.drawable.blueberry);
                } else if (i == 2) {
                    btnGorsel.setBackgroundResource(R.drawable.cherry);
                } else if (i == 3) {
                    btnGorsel.setBackgroundResource(R.drawable.grapes);
                } else if (i == 4) {
                    btnGorsel.setBackgroundResource(R.drawable.melon);
                } else if (i == 5) {
                    btnGorsel.setBackgroundResource(R.drawable.orange_f);
                } else if (i == 6) {
                    btnGorsel.setBackgroundResource(R.drawable.peach);
                } else if (i == 7) {
                    btnGorsel.setBackgroundResource(R.drawable.pear);
                } else if (i == 8) {
                    btnGorsel.setBackgroundResource(R.drawable.pineapple);
                } else if (i == 9) {
                    btnGorsel.setBackgroundResource(R.drawable.strawberry);
                }else if (i == 10) {
                    btnGorsel.setBackgroundResource(R.drawable.watermelon);
                }
                if(i==11) {
                    i--;
                }
            }
        });
    }
}