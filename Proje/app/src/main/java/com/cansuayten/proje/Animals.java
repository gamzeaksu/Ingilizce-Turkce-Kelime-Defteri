package com.cansuayten.proje;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Animals extends AppCompatActivity {
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
    private MediaPlayer mediaPlayer12;
    private MediaPlayer mediaPlayer13;
    private MediaPlayer mediaPlayer14;
    private MediaPlayer mediaPlayer15;
    private MediaPlayer mediaPlayer16;
    private MediaPlayer mediaPlayer17;
    String[] kelime = {"Bird", "Cat", "Chicken", "Cow", "Crocodile", "Dog", "Duck" ,"Fish" ,"Horse" ,"Lion","Mouse","Pig","Rabbit","Snake","Spider","Tiger","Turtle"};
    String[] anlam = {"Kuş", "Kedi", "Tavuk", "İnek", "Timsah", "Köpek", "Ördek" ,"Balık" ,"At" ,"Aslan","Fare","Domuz","Tavşan","Yılan","Örümcek","Kaplan","Kaplumbağa"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        btnGorsel =(ImageView) findViewById(R.id.btnGorsel);
        btnSes =(ImageView) findViewById(R.id.btnSes);
        btnCocukSonraki = (Button) findViewById(R.id.btnCocukSonraki);
        btnCocukOnceki = (Button) findViewById(R.id.btnCocukOnceki);
        btnAlistirmalariGor = (Button) findViewById(R.id.btnAlistirmalariGor);
        txtKelime = (TextView) findViewById(R.id.txtKelime);
        txtAnlam = (TextView) findViewById(R.id.txtAnlam);
        i = 0;

        mediaPlayer1 = MediaPlayer.create(this, R.raw.bird);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.cat);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.chicken);
        mediaPlayer4 = MediaPlayer.create(this, R.raw.cow);
        mediaPlayer5 = MediaPlayer.create(this, R.raw.crocodile);
        mediaPlayer6 = MediaPlayer.create(this, R.raw.dog);
        mediaPlayer7 = MediaPlayer.create(this, R.raw.duck);
        mediaPlayer8 = MediaPlayer.create(this, R.raw.fish);
        mediaPlayer9 = MediaPlayer.create(this, R.raw.horse);
        mediaPlayer10 = MediaPlayer.create(this, R.raw.lion);
        mediaPlayer11 = MediaPlayer.create(this, R.raw.mouse);
        mediaPlayer12 = MediaPlayer.create(this, R.raw.pig);
        mediaPlayer13 = MediaPlayer.create(this, R.raw.rabbit);
        mediaPlayer14 = MediaPlayer.create(this, R.raw.snake);
        mediaPlayer15 = MediaPlayer.create(this, R.raw.spider);
        mediaPlayer16 = MediaPlayer.create(this, R.raw.tiger);
        mediaPlayer17 = MediaPlayer.create(this, R.raw.turtle);
        btnCocukOnceki.setVisibility(View.INVISIBLE);
        btnSes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i == 0) {
                    mediaPlayer1.start();
                } else if (i == 1) {
                    mediaPlayer2.start();
                } else if (i == 2) {
                    mediaPlayer3.start();
                } else if (i == 3) {
                    mediaPlayer4.start();
                } else if (i == 4) {
                    mediaPlayer5.start();
                } else if (i == 5) {
                    mediaPlayer6.start();
                    ;
                } else if (i == 6) {
                    mediaPlayer7.start();
                } else if (i == 7) {
                    mediaPlayer8.start();
                } else if (i == 8) {
                    mediaPlayer9.start();
                } else if (i == 9) {
                    mediaPlayer10.start();
                } else if (i == 10) {
                    mediaPlayer11.start();
                } else if (i == 11) {
                    mediaPlayer12.start();
                } else if (i == 12) {
                    mediaPlayer13.start();
                } else if (i == 13) {
                    mediaPlayer14.start();
                } else if (i == 14) {
                    mediaPlayer15.start();
                } else if (i == 15) {
                    mediaPlayer16.start();
                } else if (i == 16) {
                    mediaPlayer17.start();
                }
            }
        });
        btnAlistirmalariGor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAlistirmalariGor.setVisibility(View.INVISIBLE);
                btnGorsel.setBackgroundResource(R.drawable.bird);
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
                    btnGorsel.setBackgroundResource(R.drawable.cat);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 2) {
                    btnGorsel.setBackgroundResource(R.drawable.chicken);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 3) {
                    btnGorsel.setBackgroundResource(R.drawable.cow);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 4) {
                    btnGorsel.setBackgroundResource(R.drawable.crocodile);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 5) {
                    btnGorsel.setBackgroundResource(R.drawable.dog);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 6) {
                    btnGorsel.setBackgroundResource(R.drawable.duck);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 7) {
                    btnGorsel.setBackgroundResource(R.drawable.fish);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 8) {
                    btnGorsel.setBackgroundResource(R.drawable.horse);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 9) {
                    btnGorsel.setBackgroundResource(R.drawable.lion);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 10) {
                    btnGorsel.setBackgroundResource(R.drawable.mouse);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 11) {
                    btnGorsel.setBackgroundResource(R.drawable.pig);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 12) {
                    btnGorsel.setBackgroundResource(R.drawable.rabbit);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 13) {
                    btnGorsel.setBackgroundResource(R.drawable.snake);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 14) {
                    btnGorsel.setBackgroundResource(R.drawable.spider);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 15) {
                    btnGorsel.setBackgroundResource(R.drawable.tiger);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 16) {
                    btnGorsel.setBackgroundResource(R.drawable.turtle);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else {
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
                    btnGorsel.setBackgroundResource(R.drawable.bird);
                } else if (i == 1) {
                    btnGorsel.setBackgroundResource(R.drawable.cat);
                } else if (i == 2) {
                    btnGorsel.setBackgroundResource(R.drawable.chicken);
                } else if (i == 3) {
                    btnGorsel.setBackgroundResource(R.drawable.cow);
                } else if (i == 4) {
                    btnGorsel.setBackgroundResource(R.drawable.crocodile);
                } else if (i == 5) {
                    btnGorsel.setBackgroundResource(R.drawable.dog);
                } else if (i == 6) {
                    btnGorsel.setBackgroundResource(R.drawable.duck);
                } else if (i == 7) {
                    btnGorsel.setBackgroundResource(R.drawable.fish);
                } else if (i == 8) {
                    btnGorsel.setBackgroundResource(R.drawable.horse);
                } else if (i == 9) {
                    btnGorsel.setBackgroundResource(R.drawable.lion);
                } else if (i == 10) {
                    btnGorsel.setBackgroundResource(R.drawable.mouse);
                } else if (i == 11) {
                    btnGorsel.setBackgroundResource(R.drawable.pig);
                } else if (i == 12) {
                    btnGorsel.setBackgroundResource(R.drawable.rabbit);
                } else if (i == 13) {
                    btnGorsel.setBackgroundResource(R.drawable.snake);
                } else if (i == 14) {
                    btnGorsel.setBackgroundResource(R.drawable.spider);
                } else if (i == 15) {
                    btnGorsel.setBackgroundResource(R.drawable.tiger);
                } else if (i == 16) {
                    btnGorsel.setBackgroundResource(R.drawable.turtle);
                }
                if (i == 17) {
                    i--;
                }
            }
        });
    }
}