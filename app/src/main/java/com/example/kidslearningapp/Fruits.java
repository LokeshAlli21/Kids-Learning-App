package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.Locale;

public class Fruits extends AppCompatActivity implements View.OnClickListener {

    String[] numbers = new String[] {"apple", "strawberry", "banana","mango","grapes","orange","guava","watermelon","coconut","papaya","blueberry","cherry","pear","custard apple","kiwi"};
    TextToSpeech speak;
    ImageButton apple,strawberry,banana,mango,grapes,orange,guava,watermelon,coconut,papaya,blueberry,cherry,pear,custard_apple,kiwi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);

        apple = findViewById(R.id.apple);
        strawberry = findViewById(R.id.strawberry);
        banana = findViewById(R.id.banana);
        mango = findViewById(R.id.mango);
        grapes = findViewById(R.id.grapes);
        orange = findViewById(R.id.orange);
        guava = findViewById(R.id.guava);
        watermelon = findViewById(R.id.watermelon);

        coconut = findViewById(R.id.coconut);
        papaya = findViewById(R.id.papaya);
        blueberry = findViewById(R.id.blueberry);
        cherry = findViewById(R.id.cherry);
        pear = findViewById(R.id.pear);
        custard_apple = findViewById(R.id.custard_apple);
        kiwi = findViewById(R.id.kiwi);

        speak = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = speak.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        apple.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        apple.setOnClickListener(this);
        strawberry.setOnClickListener(this);
        banana.setOnClickListener(this);
        mango.setOnClickListener(this);
        grapes.setOnClickListener(this);
        orange.setOnClickListener(this);
        guava.setOnClickListener(this);
        watermelon.setOnClickListener(this);

        coconut.setOnClickListener(this);
        papaya.setOnClickListener(this);
        blueberry.setOnClickListener(this);
        cherry.setOnClickListener(this);
        pear.setOnClickListener(this);
        custard_apple.setOnClickListener(this);
        kiwi.setOnClickListener(this);


    }

    private void speak(int i ) {
        String text = numbers[i];
        float pitch = (float) 0.60;
        if (pitch < 0.1) pitch = 0.1f;
        float speed = (float) 0.55;
        if (speed < 0.1) speed = 0.1f;

        speak.setPitch(pitch);
        speak.setSpeechRate(speed);

        speak.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }

    @Override
    protected void onDestroy() {
        if (speak != null) {
            speak.stop();
            speak.shutdown();
        }

        super.onDestroy();
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.apple){
            speak(0);
        } else if (view.getId() == R.id.strawberry){
            speak(1);
        } else if (view.getId() == R.id.banana){
            speak(2);
        } else if (view.getId() == R.id.mango){
            speak(3);
        } else if (view.getId() == R.id.grapes){
            speak(4);
        } else if (view.getId() == R.id.orange){
            speak(5);
        } else if (view.getId() == R.id.guava){
            speak(6);
        } else if (view.getId() == R.id.watermelon){
            speak(7);
        } else if (view.getId() == R.id.coconut){
            speak(8);
        } else if (view.getId() == R.id.papaya){
            speak(9);
        } else if (view.getId() == R.id.blueberry){
            speak(10);
        } else if (view.getId() == R.id.cherry){
            speak(11);
        } else if (view.getId() == R.id.pear){
            speak(12);
        } else if (view.getId() == R.id.custard_apple){
            speak(13);
        } else if (view.getId() == R.id.kiwi){
            speak(14);
        }

    }
}