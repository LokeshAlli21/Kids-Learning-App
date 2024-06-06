package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Locale;

public class Test extends AppCompatActivity implements View.OnClickListener {

    TextToSpeech speak;
    String speak_q_a[] = {
            "a for",
            "How many cows are there",
            " where is onion",
            "which is wild animal ",
            "guess the spelling of one",
            "guess the colour",
            "which is owl",
            "count the vehicles",
            "How many pumpkins are there",
            "guess seven in number",
            "very nice, your answer is correct ","oh no, its a wrong answer"};

    ImageView q1opt1,q1opt2,q1opt3,q1opt4,q3opt1,q3opt2,q3opt3,q3opt4,q4opt1,q4opt2,q4opt3,q4opt4,q7opt1,q7opt2,q7opt3,q7opt4;
    Button q2opt1,q2opt2,q2opt3,q2opt4,q5opt1,q5opt2,q5opt3,q5opt4,q6opt1,q6opt2,q6opt3,q6opt4,q8opt1,q8opt2,q8opt3,q8opt4,q9opt1,q9opt2,q9opt3,q9opt4,q10opt1,q10opt2,q10opt3,q10opt4;
    TextView how_many_cows,where_is_onion,which_is_wild,is_this_colours,which_is_bird,count_vehicles,how_many_pumpkins,seven_in_number;
    LinearLayout a_for,spelling_of_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        a_for = findViewById(R.id.a_for);
        how_many_cows = findViewById(R.id.how_many_cows);
        where_is_onion = findViewById(R.id.where_is_onion);
        which_is_wild = findViewById(R.id.which_is_wild);
        spelling_of_one = findViewById(R.id.spelling_of_one);
        is_this_colours = findViewById(R.id.is_this_colours);
        which_is_bird = findViewById(R.id.which_is_bird);
        count_vehicles = findViewById(R.id.count_vehicles);

        how_many_pumpkins = findViewById(R.id.how_many_pumpkins);
        seven_in_number = findViewById(R.id.seven_in_number);

        q1opt1 = findViewById(R.id.q1opt1);
        q1opt2 = findViewById(R.id.q1opt2);
        q1opt3 = findViewById(R.id.q1opt3);
        q1opt4 = findViewById(R.id.q1opt4);

        q3opt1 = findViewById(R.id.q3opt1);
        q3opt2 = findViewById(R.id.q3opt2);
        q3opt3 = findViewById(R.id.q3opt3);
        q3opt4 = findViewById(R.id.q3opt4);
        q4opt1 = findViewById(R.id.q4opt1);
        q4opt2 = findViewById(R.id.q4opt2);
        q4opt3 = findViewById(R.id.q4opt3);
        q4opt4 = findViewById(R.id.q4opt4);
        q7opt1 = findViewById(R.id.q7opt1);
        q7opt2 = findViewById(R.id.q7opt2);
        q7opt3 = findViewById(R.id.q7opt3);
        q7opt4 = findViewById(R.id.q7opt4);
        q2opt1 = findViewById(R.id.q2opt1);
        q2opt2 = findViewById(R.id.q2opt2);
        q2opt3 = findViewById(R.id.q2opt3);
        q2opt4 = findViewById(R.id.q2opt4);

        q5opt1 = findViewById(R.id.q5opt1);
        q5opt2 = findViewById(R.id.q5opt2);
        q5opt3 = findViewById(R.id.q5opt3);
        q5opt4 = findViewById(R.id.q5opt4);
        q6opt1 = findViewById(R.id.q6opt1);
        q6opt2 = findViewById(R.id.q6opt2);
        q6opt3 = findViewById(R.id.q6opt3);
        q6opt4 = findViewById(R.id.q6opt4);

        q8opt1 = findViewById(R.id.q8opt1);
        q8opt2 = findViewById(R.id.q8opt2);
        q8opt3 = findViewById(R.id.q8opt3);
        q8opt4 = findViewById(R.id.q8opt4);
        q9opt1 = findViewById(R.id.q9opt1);
        q9opt2 = findViewById(R.id.q9opt2);
        q9opt3 = findViewById(R.id.q9opt3);
        q9opt4 = findViewById(R.id.q9opt4);
        q10opt1 = findViewById(R.id.q10opt1);
        q10opt2 = findViewById(R.id.q10opt2);
        q10opt3 = findViewById(R.id.q10opt3);
        q10opt4 = findViewById(R.id.q10opt4);

        speak = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = speak.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        a_for.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });

        a_for.setOnClickListener(this);
        how_many_cows.setOnClickListener(this);
        where_is_onion.setOnClickListener(this);
        which_is_wild.setOnClickListener(this);
        spelling_of_one.setOnClickListener(this);
        is_this_colours.setOnClickListener(this);
        which_is_bird.setOnClickListener(this);
        count_vehicles.setOnClickListener(this);
        how_many_pumpkins.setOnClickListener(this);
        seven_in_number.setOnClickListener(this);

        q1opt1.setOnClickListener(this);
        q1opt2.setOnClickListener(this);
        q3opt1.setOnClickListener(this);
        q3opt2.setOnClickListener(this);
        q3opt3.setOnClickListener(this);
        q3opt4.setOnClickListener(this);
        q4opt1.setOnClickListener(this);
        q4opt2.setOnClickListener(this);
        q4opt3.setOnClickListener(this);
        q4opt4.setOnClickListener(this);
        q7opt1.setOnClickListener(this);
        q7opt2.setOnClickListener(this);
        q7opt3.setOnClickListener(this);
        q7opt4.setOnClickListener(this);
        q2opt1.setOnClickListener(this);
        q2opt2.setOnClickListener(this);
        q5opt1.setOnClickListener(this);
        q5opt2.setOnClickListener(this);
        q5opt3.setOnClickListener(this);
        q5opt4.setOnClickListener(this);
        q6opt1.setOnClickListener(this);
        q6opt2.setOnClickListener(this);
        q8opt1.setOnClickListener(this);
        q8opt2.setOnClickListener(this);
        q8opt3.setOnClickListener(this);
        q8opt4.setOnClickListener(this);
        q1opt3.setOnClickListener(this);
        q1opt4.setOnClickListener(this);
        q2opt3.setOnClickListener(this);
        q2opt4.setOnClickListener(this);
        q6opt3.setOnClickListener(this);
        q6opt4.setOnClickListener(this);
        q9opt1.setOnClickListener(this);
        q9opt2.setOnClickListener(this);
        q9opt3.setOnClickListener(this);
        q9opt4.setOnClickListener(this);
        q10opt1.setOnClickListener(this);
        q10opt2.setOnClickListener(this);
        q10opt3.setOnClickListener(this);
        q10opt4.setOnClickListener(this);

    }

    private void speak(int i ) {
        String text = speak_q_a[i];
        float pitch = (float) 0.70;
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

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.a_for){
            speak(0);
        } else if (view.getId() == R.id.how_many_cows){
            speak(1);
        } else if (view.getId() == R.id.where_is_onion){
            speak(2);
        } else if (view.getId() == R.id.which_is_wild){
            speak(3);
        } else if (view.getId() == R.id.spelling_of_one){
            speak(4);
        } else if (view.getId() == R.id.is_this_colours){
            speak(5);
        } else if (view.getId() == R.id.which_is_bird){
            speak(6);
        } else if (view.getId() == R.id.count_vehicles){
            speak(7);
        } else if (view.getId() == R.id.how_many_pumpkins){
            speak(8);
        } else if (view.getId() == R.id.seven_in_number){
            speak(9);
        } else if (
                view.getId() == R.id.q1opt3 ||
                view.getId() == R.id.q2opt4 ||
                view.getId() == R.id.q3opt2 ||
                view.getId() == R.id.q4opt4 ||
                view.getId() == R.id.q5opt3 ||
                view.getId() == R.id.q6opt2 ||
                view.getId() == R.id.q7opt4 ||
                view.getId() == R.id.q8opt2 ||
                view.getId() == R.id.q9opt3 ||
                view.getId() == R.id.q10opt3 ){
            speak(10);
        } else {
            speak(11);
        }

    }
}