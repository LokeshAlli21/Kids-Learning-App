package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class Anim5 extends AppCompatActivity implements View.OnClickListener {

    private ConstraintLayout layout;
    TextToSpeech speak;
    TextView tv;
    private Placeholder placeholder;
    String[] numbers = new String[] { "wrong, please count correctly ","brilliant, you counted correctly, there are four cauliflowers ","how many cauliflowers are there"};
    ImageView obj1,obj2,obj3,obj4,obj5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim5);
        layout = findViewById(R.id.layout5);
        placeholder = findViewById(R.id.placeholder5);

        obj1 = findViewById(R.id.obj1);
        obj2 = findViewById(R.id.obj2);
        obj3 = findViewById(R.id.obj3);
        obj4 = findViewById(R.id.obj4);
        obj5 = findViewById(R.id.obj5);
        tv = findViewById(R.id.tv);

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

        obj1.setOnClickListener(this);
        obj2.setOnClickListener(this);
        obj3.setOnClickListener(this);
        obj4.setOnClickListener(this);
        obj5.setOnClickListener(this);
        tv.setOnClickListener(this);


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

    public void swapView(View v) {
        TransitionManager.beginDelayedTransition(layout);
        placeholder.setContentId(v.getId());
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.obj1){
            speak(0);
            TransitionManager.beginDelayedTransition(layout);
            placeholder.setContentId(view.getId());
        } else if (view.getId() == R.id.obj2){
            speak(0);
            TransitionManager.beginDelayedTransition(layout);
            placeholder.setContentId(view.getId());
        } else if (view.getId() == R.id.obj3){
            speak(0);
            TransitionManager.beginDelayedTransition(layout);
            placeholder.setContentId(view.getId());
        } else if (view.getId() == R.id.obj4){
            speak(1);
            TransitionManager.beginDelayedTransition(layout);
            placeholder.setContentId(view.getId());
        } else if (view.getId() == R.id.obj5){
            speak(0);
            TransitionManager.beginDelayedTransition(layout);
            placeholder.setContentId(view.getId());
        }  else if (view.getId() == R.id.tv){
            speak(2);
        }

    }


}