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

public class Birds extends AppCompatActivity {

    String[] numbers = new String[] {"parrot talks", "peacock screams", "owl hoots","sparrow chirps","duck quacks","pigeon coos","crow caws","hen clucks"};
    TextToSpeech speak;
    ImageButton parrot,peacock,owl,sparrow,duck,pigeon,crow,hen;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birds);

        parrot = findViewById(R.id.parrot);
        peacock = findViewById(R.id.peacock);
        owl = findViewById(R.id.owl);
        sparrow = findViewById(R.id.sparrow);
        duck = findViewById(R.id.duck);
        pigeon = findViewById(R.id.pigeon);
        crow = findViewById(R.id.crow);
        hen = findViewById(R.id.hen);

        speak = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = speak.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        parrot.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        parrot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Birds.this, R.raw.parrot_sound);
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
        peacock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Birds.this, R.raw.peacock_sound);
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
        owl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Birds.this, R.raw.owl_sound);
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
        sparrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Birds.this, R.raw.sparrow_sound);
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
        duck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Birds.this, R.raw.duck_sound);
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
        pigeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Birds.this, R.raw.pigeon_sound);
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
        crow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Birds.this, R.raw.crow_sound);
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
        hen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Birds.this, R.raw.hen_sound);
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