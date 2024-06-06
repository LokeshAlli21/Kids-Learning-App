package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

public class Colours extends AppCompatActivity implements View.OnClickListener {

    String[] numbers = new String[] {"red colour", "blue colour", "yellow colour","green colour","orange colour","pink colour","brown colour","purple colour"};
    TextToSpeech speak;
    TextView red,blue,yellow,green,orange,pink,brown,purple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colours);

        red = findViewById(R.id.red);
        blue = findViewById(R.id.blue);
        yellow = findViewById(R.id.yellow);
        green = findViewById(R.id.green);
        orange = findViewById(R.id.orange);
        pink = findViewById(R.id.pink);
        brown = findViewById(R.id.brown);
        purple = findViewById(R.id.purple);

        speak = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = speak.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        red.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        red.setOnClickListener(this);
        blue.setOnClickListener(this);
        yellow.setOnClickListener(this);
        green.setOnClickListener(this);
        orange.setOnClickListener(this);
        pink.setOnClickListener(this);
        brown.setOnClickListener(this);
        purple.setOnClickListener(this);

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
        if (view.getId() == R.id.red){
            speak(0);
        } else if (view.getId() == R.id.blue){
            speak(1);
        } else if (view.getId() == R.id.yellow){
            speak(2);
        } else if (view.getId() == R.id.green){
            speak(3);
        } else if (view.getId() == R.id.orange){
            speak(4);
        } else if (view.getId() == R.id.pink){
            speak(5);
        } else if (view.getId() == R.id.brown){
            speak(6);
        } else if (view.getId() == R.id.purple){
            speak(7);
        }

    }

}