package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.Locale;

public class Vegetables extends AppCompatActivity implements View.OnClickListener {

    String[] numbers = new String[] {"potato", "onion", "cabbage","brinjal","spinach","raddish","pumpkin","chilli","bitter gourd","lady's finger","cauliflower","capsicum","green beans","bottle guard","cucumber"};
    TextToSpeech speak;
    ImageButton potato,onion,cabbage,brinjal,spinach,raddish,pumpkin,chilli,bitter_gourd,ladyfinger,cauliflower,capsicum,green_beans,bottle_guard,cucumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vegetables);

        potato = findViewById(R.id.potato);
        onion = findViewById(R.id.onion);
        cabbage = findViewById(R.id.cabbage);
        brinjal = findViewById(R.id.brinjal);
        spinach = findViewById(R.id.spinach);
        raddish = findViewById(R.id.raddish);
        pumpkin = findViewById(R.id.pumpkin);
        chilli = findViewById(R.id.chilli);

        bitter_gourd = findViewById(R.id.bitter_gourd);
        ladyfinger = findViewById(R.id.ladyfinger);
        cauliflower = findViewById(R.id.cauliflower);
        capsicum = findViewById(R.id.capsicum);
        green_beans = findViewById(R.id.green_beans);
        bottle_guard = findViewById(R.id.bottle_guard);
        cucumber = findViewById(R.id.cucumber);

        speak = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = speak.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        potato.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        potato.setOnClickListener(this);
        onion.setOnClickListener(this);
        cabbage.setOnClickListener(this);
        brinjal.setOnClickListener(this);
        spinach.setOnClickListener(this);
        raddish.setOnClickListener(this);
        pumpkin.setOnClickListener(this);
        chilli.setOnClickListener(this);

        bitter_gourd.setOnClickListener(this);
        ladyfinger.setOnClickListener(this);
        cauliflower.setOnClickListener(this);
        capsicum.setOnClickListener(this);
        green_beans.setOnClickListener(this);
        bottle_guard.setOnClickListener(this);
        cucumber.setOnClickListener(this);
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

        if (view.getId() == R.id.potato){
            speak(0);
        } else if (view.getId() == R.id.onion){
            speak(1);
        } else if (view.getId() == R.id.cabbage){
            speak(2);
        } else if (view.getId() == R.id.brinjal){
            speak(3);
        } else if (view.getId() == R.id.spinach){
            speak(4);
        } else if (view.getId() == R.id.raddish){
            speak(5);
        } else if (view.getId() == R.id.pumpkin){
            speak(6);
        } else if (view.getId() == R.id.chilli){
            speak(7);
        } else if (view.getId() == R.id.bitter_gourd){
            speak(8);
        } else if (view.getId() == R.id.ladyfinger){
            speak(9);
        } else if (view.getId() == R.id.cauliflower){
            speak(10);
        } else if (view.getId() == R.id.capsicum){
            speak(11);
        } else if (view.getId() == R.id.green_beans){
            speak(12);
        } else if (view.getId() == R.id.bottle_guard){
            speak(13);
        } else if (view.getId() == R.id.cucumber){
            speak(14);
        }


    }
}