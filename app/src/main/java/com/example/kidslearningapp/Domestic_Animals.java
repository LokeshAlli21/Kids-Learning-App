package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.Locale;

public class Domestic_Animals extends AppCompatActivity {

    String[] numbers = new String[] {"cat meows", "dog baarks", "camel grunts","cow moos","donkey brays","goat bleats","rabbit   squeaks","sheep bleats"};
    TextToSpeech speak;
    ImageButton cat,dog,camel,cow,donkey,goat,rabbit,sheep;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_domestic_animals);

        cat = findViewById(R.id.cat);
        dog = findViewById(R.id.dog);
        camel = findViewById(R.id.camel);
        cow = findViewById(R.id.cow);
        donkey = findViewById(R.id.donkey);
        goat = findViewById(R.id.goat);
        rabbit = findViewById(R.id.rabbit);
        sheep = findViewById(R.id.sheep);

        speak = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = speak.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        cat.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Domestic_Animals.this, R.raw.cat_sound);
                speak(0);
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer.start();
                }, 1500);
            }
        });
        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Domestic_Animals.this, R.raw.dog_sound);
                speak(1);
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer.start();
                }, 1500);
            }
        });
        camel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Domestic_Animals.this, R.raw.camel_sound);
                speak(2);
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer.start();
                }, 1500);
            }
        });
        cow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Domestic_Animals.this, R.raw.cow_sound);
                speak(3);
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer.start();
                }, 1500);
            }
        });
        donkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Domestic_Animals.this, R.raw.donkey_sound);
                speak(4);
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer.start();
                }, 1500);
            }
        });
        goat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Domestic_Animals.this, R.raw.goat_sound);
                speak(5);
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer.start();
                }, 1500);
            }
        });
        rabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Domestic_Animals.this, R.raw.rabbit_sound);
                speak(6);
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer.start();
                }, 1500);
            }
        });
        sheep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Domestic_Animals.this, R.raw.sheep_sound);
                speak(7);
                Handler handler = new Handler();
                handler.postDelayed(() -> {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                    }
                    mediaPlayer.start();
                }, 1500);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer != null){
            mediaPlayer.stop();
        }
    }

    private void speak(int i ) {
        String text = numbers[i];
        float pitch = (float) 0.60;
        if (pitch < 0.1) pitch = 0.1f;
        float speed = (float) 0.55;
        if (speed < 0.1) speed = 0.1f;

        speak.setPitch(pitch);
        speak.setSpeechRate(speed);

//        speak.speak(text, TextToSpeech.QUEUE_FLUSH, null);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            speak.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);
        } else {
            speak.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    @Override
    protected void onDestroy() {
        if (speak != null) {
            speak.stop();
            speak.shutdown();
        }

        super.onDestroy();
    }
}