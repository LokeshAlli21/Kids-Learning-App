package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.Locale;

public class Numbers extends AppCompatActivity implements View.OnClickListener {

    String[] numbers = new String[] {"o n e one", "t w o two", "t h r double e three","f o u r four","f i we e five","s i x six","s e v e n seven","e i g h t eight","n i n e nine","t e n ten"};
    TextToSpeech speak;
    ImageButton one,two,three,four,five,six,seven,eight,nine,ten;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        ten = findViewById(R.id.ten);

        speak = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = speak.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        one.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        ten.setOnClickListener(this);



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

        if (view.getId() == R.id.one){
            speak(0);
        } else if (view.getId() == R.id.two){
            speak(1);
        } else if (view.getId() == R.id.three){
            speak(2);
        } else if (view.getId() == R.id.four){
            speak(3);
        } else if (view.getId() == R.id.five){
            speak(4);
        } else if (view.getId() == R.id.six){
            speak(5);
        } else if (view.getId() == R.id.seven){
            speak(6);
        } else if (view.getId() == R.id.eight){
            speak(7);
        } else if (view.getId() == R.id.nine){
            speak(8);
        } else if (view.getId() == R.id.ten) {
            speak(9);
        }

    }
}