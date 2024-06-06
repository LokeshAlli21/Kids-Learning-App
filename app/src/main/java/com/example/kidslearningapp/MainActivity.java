package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CardView alphabets,numbers,d_animals,w_animals,birds,fruits,vegetables,vehicles,rhymes,colours,test,fun_learning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alphabets = findViewById(R.id.alphabets);
        numbers = findViewById(R.id.numbers);
        d_animals = findViewById(R.id.d_animals);
        w_animals = findViewById(R.id.w_animals);
        birds = findViewById(R.id.birds);
        fruits = findViewById(R.id.fruits);
        vegetables = findViewById(R.id.vegetables);
        vehicles = findViewById(R.id.vehicles);
        rhymes = findViewById(R.id.rhymes);
        colours = findViewById(R.id.colours);
        test = findViewById(R.id.test);
        fun_learning = findViewById(R.id.fun_learning);


        alphabets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Alphabets.class);
                startActivity(intent);
            }
        });

        numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Numbers.class);
                startActivity(intent);
            }
        });

        d_animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Domestic_Animals.class);
                startActivity(intent);
            }
        });

        w_animals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Wild_Animals.class);
                startActivity(intent);
            }
        });

        birds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Birds.class);
                startActivity(intent);
            }
        });

        fruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Fruits.class);
                startActivity(intent);
            }
        });

        vegetables.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Vegetables.class);
                startActivity(intent);
            }
        });

        vehicles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Vehicles.class);
                startActivity(intent);
            }
        });

        rhymes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Rhymes.class);
                startActivity(intent);
            }
        });

        colours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Colours.class);
                startActivity(intent);
            }
        });

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Test.class);
                startActivity(intent);
            }
        });

        fun_learning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Fun.class);
                startActivity(intent);
            }
        });

    }
}