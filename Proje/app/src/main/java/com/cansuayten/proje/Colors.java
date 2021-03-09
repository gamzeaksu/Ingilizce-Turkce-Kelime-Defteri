package com.cansuayten.proje;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Colors extends AppCompatActivity {
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
    String[] kelime = {"Black", "Blue", "Brown", "Green", "Orange", "Pink", "Purple" ,"Red" ,"White" ,"Yelllow"};
    String[] anlam = {"Siyah", "Mavi", "Kahverengi", "Yeşil", "Turuncu", "Pembe", "Mor" ,"Kırmızı" ,"Beyaz" ,"Sarı"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);
        btnGorsel =(ImageView) findViewById(R.id.btnGorsel);
        btnSes =(ImageView) findViewById(R.id.btnSes);
        btnCocukSonraki = (Button) findViewById(R.id.btnCocukSonraki);
        btnCocukOnceki = (Button) findViewById(R.id.btnCocukOnceki);
        btnAlistirmalariGor = (Button) findViewById(R.id.btnAlistirmalariGor);
        txtKelime = (TextView) findViewById(R.id.txtKelime);
        txtAnlam = (TextView) findViewById(R.id.txtAnlam);
        i = 0;

        mediaPlayer1 = MediaPlayer.create(this, R.raw.black);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.blue);
        mediaPlayer3 = MediaPlayer.create(this, R.raw.brown);
        mediaPlayer4 = MediaPlayer.create(this, R.raw.green);
        mediaPlayer5 = MediaPlayer.create(this, R.raw.orange);
        mediaPlayer6 = MediaPlayer.create(this, R.raw.pink);
        mediaPlayer7 = MediaPlayer.create(this, R.raw.purple);
        mediaPlayer8 = MediaPlayer.create(this, R.raw.red);
        mediaPlayer9 = MediaPlayer.create(this, R.raw.white);
        mediaPlayer10 = MediaPlayer.create(this, R.raw.yellow);
        btnCocukOnceki.setVisibility(View.INVISIBLE);
        //btn.setBackgroundResource(R.drawable.new_todo_image);
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
                }

            }
        });
        btnAlistirmalariGor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnAlistirmalariGor.setVisibility(View.INVISIBLE);
                btnGorsel.setBackgroundResource(R.drawable.black);
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
                    btnGorsel.setBackgroundResource(R.drawable.blue);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 2) {
                    btnGorsel.setBackgroundResource(R.drawable.brown);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 3) {
                    btnGorsel.setBackgroundResource(R.drawable.green);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 4) {
                    btnGorsel.setBackgroundResource(R.drawable.orange);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 5) {
                    btnGorsel.setBackgroundResource(R.drawable.pink);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 6) {
                    btnGorsel.setBackgroundResource(R.drawable.purple);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 7) {
                    btnGorsel.setBackgroundResource(R.drawable.red);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 8) {
                    btnGorsel.setBackgroundResource(R.drawable.white);
                    txtAnlam.setText("Meaning:" + anlam[i]);
                    txtKelime.setText("Word: " + kelime[i]);
                } else if (i == 9) {
                    btnGorsel.setBackgroundResource(R.drawable.yellow);
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
                    btnGorsel.setBackgroundResource(R.drawable.black);
                } else if (i == 1) {
                    btnGorsel.setBackgroundResource(R.drawable.blue);
                } else if (i == 2) {
                    btnGorsel.setBackgroundResource(R.drawable.brown);
                } else if (i == 3) {
                    btnGorsel.setBackgroundResource(R.drawable.green);
                } else if (i == 4) {
                    btnGorsel.setBackgroundResource(R.drawable.orange);
                } else if (i == 5) {
                    btnGorsel.setBackgroundResource(R.drawable.pink);
                } else if (i == 6) {
                    btnGorsel.setBackgroundResource(R.drawable.purple);
                } else if (i == 7) {
                    btnGorsel.setBackgroundResource(R.drawable.red);
                } else if (i == 8) {
                    btnGorsel.setBackgroundResource(R.drawable.white);
                } else if (i == 9) {
                    btnGorsel.setBackgroundResource(R.drawable.yellow);
                }
                if(i==10) {
                    i--;
                }
            }
        });
    }

}