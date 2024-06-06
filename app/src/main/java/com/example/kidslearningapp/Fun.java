package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Fun extends AppCompatActivity {

    CardView gif,anim1,anim2,anim3,anim4,anim5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun);
        anim1 = findViewById(R.id.anim1);
        anim2 = findViewById(R.id.anim2);
        anim3 = findViewById(R.id.anim3);
        anim4 = findViewById(R.id.anim4);
        anim5 = findViewById(R.id.anim5);
        gif = findViewById(R.id.gif);


        gif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fun.this,Gif.class);
                startActivity(intent);
            }
        });

        anim1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fun.this, Anim1.class);
                startActivity(intent);
            }
        });

        anim2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fun.this, Anim2.class);
                startActivity(intent);
            }
        });

        anim3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fun.this, Anim3.class);
                startActivity(intent);
            }
        });

        anim4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fun.this, Anim4.class);
                startActivity(intent);
            }
        });

        anim5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fun.this, Anim5.class);
                startActivity(intent);
            }
        });

    }
}