package com.cansuayten.proje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class DinlemePratik extends AppCompatActivity {

    private int flag;
    public String dogrusonuc;
    private Button b,b2,b3;
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
    private MediaPlayer mediaPlayer18;
    private MediaPlayer mediaPlayer19;
    private MediaPlayer mediaPlayer20;
    private MediaPlayer mediaPlayer21;
    private MediaPlayer mediaPlayer22;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinleme_pratik);
        b = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        EditText text = (EditText) findViewById(R.id.editText);
        TextView text2 = (TextView) findViewById(R.id.textView3);
        mediaPlayer1= MediaPlayer.create(this, R.raw.bird);
        mediaPlayer2=MediaPlayer.create(this, R.raw.butterfly);
        mediaPlayer3= MediaPlayer.create(this, R.raw.cat);
        mediaPlayer4= MediaPlayer.create(this, R.raw.chicken);
        mediaPlayer5 = MediaPlayer.create(this, R.raw.cow);
        mediaPlayer6= MediaPlayer.create(this, R.raw.crocodile);
        mediaPlayer7 = MediaPlayer.create(this, R.raw.dog);
        mediaPlayer8= MediaPlayer.create(this, R.raw.duck);
        mediaPlayer9= MediaPlayer.create(this, R.raw.fish);
        mediaPlayer10 = MediaPlayer.create(this, R.raw.frog);
        mediaPlayer11= MediaPlayer.create(this, R.raw.horse);
        mediaPlayer12 = MediaPlayer.create(this, R.raw.lion);
        mediaPlayer13= MediaPlayer.create(this, R.raw.mouse);
        mediaPlayer14= MediaPlayer.create(this, R.raw.pig);
        mediaPlayer15= MediaPlayer.create(this, R.raw.rabbit);
        mediaPlayer16 = MediaPlayer.create(this, R.raw.read);
        mediaPlayer17= MediaPlayer.create(this, R.raw.snake);
        mediaPlayer18= MediaPlayer.create(this, R.raw.spider);
        mediaPlayer19= MediaPlayer.create(this, R.raw.tiger);
        mediaPlayer20= MediaPlayer.create(this, R.raw.turtle);
        mediaPlayer21= MediaPlayer.create(this, R.raw.whale);
        mediaPlayer22 = MediaPlayer.create(this, R.raw.write);

        flag=0;

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = text.getText().toString();
                if(Name==dogrusonuc)
                {
                    Toast.makeText(getApplicationContext(), "Doğru cevap", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Yanlış cevap ", Toast.LENGTH_SHORT).show();
                    text2.setText("Dogru Sonuc : "+dogrusonuc);
                }
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag++;
                text.setText("");
                text2.setText("Cevap");
            }
        });


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(flag==0){
                    mediaPlayer1.start();
                    f1("bird");
                }else if(flag==1){
                    mediaPlayer2.start();
                    f1("butterfly");
                }else if(flag==2){
                    mediaPlayer3.start();
                    f1("cat");
                }else if(flag==3){
                    mediaPlayer4.start();
                    f1("chicken");
                }else if(flag==4){
                    mediaPlayer5.start();
                    f1("cow");
                }else if(flag==5){
                    mediaPlayer6.start();
                    f1("crocodile");
                }else if(flag==6){
                    mediaPlayer7.start();
                    f1("dog");
                }else if(flag==7){
                    mediaPlayer8.start();
                    f1("duck");
                }else if(flag==8){
                    mediaPlayer9.start();
                    f1("fish");
                }else if(flag==9){
                    mediaPlayer10.start();
                    f1("frog");
                }else if(flag==10){
                    mediaPlayer11.start();
                    f1("horse");
                }else if(flag==11){
                    mediaPlayer12.start();
                    f1("lion");
                }else if(flag==12){
                    mediaPlayer13.start();
                    f1("mouse");
                }else if(flag==13){
                    mediaPlayer14.start();
                    f1("pig");
                }else if(flag==14){
                    mediaPlayer15.start();
                    f1("rabbit");
                }else if(flag==15){
                    mediaPlayer16.start();
                    f1("read");
                }else if(flag==16){
                    mediaPlayer17.start();
                    f1("snake");
                }else if(flag==17){
                    mediaPlayer18.start();
                    f1("spider");
                }else if(flag==18){
                    mediaPlayer19.start();
                    f1("tiger");
                }else if(flag==19){
                    mediaPlayer20.start();
                    f1("turtle");
                }else if(flag==20){
                    mediaPlayer21.start();
                    f1("whale");
                }else if(flag==21){
                    mediaPlayer22.start();
                    f1("write");
                }


            }



        });
    }
    public void f1(String x){
        dogrusonuc=x;
    }

}