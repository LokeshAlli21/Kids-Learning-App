package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;

import java.util.Locale;

import pl.droidsonroids.gif.GifImageView;

public class Gif extends AppCompatActivity {

    GifImageView gifView;
    TextToSpeech speak;
    String[] numbers = new String[] {"cheetah", "dog", "camel","pigeon","train","yellow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gif);

        gifView = findViewById(R.id.gifView);

        speak = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = speak.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

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

    public void showGif(View view) {

        switch (view.getId()){

            case R.id.cheetahGif:
                speak(0);
                gifView.setBackgroundResource(R.drawable.cheetah_gif);
                break;
            case R.id.dogGif:
                speak(1);
                gifView.setBackgroundResource(R.drawable.dog_gif);
                break;
            case R.id.camelGif:
                speak(2);
                gifView.setBackgroundResource(R.drawable.camel_gif);
                break;
            case R.id.pigeonGif:
                speak(3);
                gifView.setBackgroundResource(R.drawable.pigeon_gif);
                break;
            case R.id.trainGif:
                speak(4);
                gifView.setBackgroundResource(R.drawable.train_gif);
                break;
            case R.id.yellowGif:
                speak(5);
                gifView.setBackgroundResource(R.drawable.yellow_gif);
                break;

        }

    }
}