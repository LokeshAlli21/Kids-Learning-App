package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.Locale;

public class Vehicles extends AppCompatActivity {

    String[] numbers = new String[] {"car starts", "van closes", "bus honks","train whistles","bicycle trings","jeep runs","aeroplane flies","auto rickshaw horns"};
    TextToSpeech speak;
    ImageButton car,van,bus,train,bicycle,jeep,aeroplane,auto_rickshaw;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicles);

        car = findViewById(R.id.car);
        van = findViewById(R.id.van);
        bus = findViewById(R.id.bus);
        train = findViewById(R.id.train);
        bicycle = findViewById(R.id.bicycle);
        jeep = findViewById(R.id.jeep);
        aeroplane = findViewById(R.id.aeroplane);
        auto_rickshaw = findViewById(R.id.auto_rickshaw);

        speak = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = speak.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        car.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Vehicles.this, R.raw.car_sound);
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
        van.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Vehicles.this, R.raw.van_sound);
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
        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Vehicles.this, R.raw.bus_sound);
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
        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Vehicles.this, R.raw.train_sound);
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
        bicycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Vehicles.this, R.raw.bicycles_sound);
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
        jeep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Vehicles.this, R.raw.jeep_sound);
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
        aeroplane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Vehicles.this, R.raw.aeroplane_sound);
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
        auto_rickshaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(Vehicles.this, R.raw.rickshaw_sound);
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

}