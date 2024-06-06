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

public class Wild_Animals extends AppCompatActivity {

    String[] numbers = new String[] {"lion roars", "tiger growls", "fox screams","bear growls","panda bleats","giraffe moans","cheetah gargles","snake hisses"};
    TextToSpeech speak;
    ImageButton lion,tiger,fox,bear,panda,giraffe,cheetah,snake;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wild_animals);

        lion = findViewById(R.id.lion);
        tiger = findViewById(R.id.tiger);
        fox = findViewById(R.id.fox);
        bear = findViewById(R.id.bear);
        panda = findViewById(R.id.panda);
        giraffe = findViewById(R.id.giraffe);
        cheetah = findViewById(R.id.cheetah);
        snake = findViewById(R.id.snake);


        speak = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = speak.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        lion.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        lion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Wild_Animals.this, R.raw.lion_sound);
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
        tiger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Wild_Animals.this, R.raw.tiger_sound);
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
        fox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Wild_Animals.this, R.raw.fox_sound);
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
        bear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Wild_Animals.this, R.raw.bear_sound);
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
        panda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Wild_Animals.this, R.raw.panda_sound);
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
        giraffe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Wild_Animals.this, R.raw.giraffe_sound);
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
        cheetah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Wild_Animals.this, R.raw.cheetah_sound);
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
        snake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Wild_Animals.this, R.raw.snake_sound);
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