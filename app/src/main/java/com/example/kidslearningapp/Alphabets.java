package com.example.kidslearningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import java.util.Locale;

public class Alphabets extends AppCompatActivity implements View.OnClickListener {

    String[] alphabets = new String[] {"a for apple", "b for book", "c for cat","d for dog","e for egg","f for frog","g for goat","h for house","i for insect","j for jam","k for key","l for leaf","m for monkey","n for nest","o for orange","p for pencil","q for queen","r for rat","s for sun","t for tree","u for umbrella","v for violin","w for whale","x for xylophone","y for yogurt","z for zebra"};
    TextToSpeech speak;
    ImageButton a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabets);

        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        d = findViewById(R.id.d);
        e = findViewById(R.id.e);
        f = findViewById(R.id.f);
        g = findViewById(R.id.g);
        h = findViewById(R.id.h);
        i = findViewById(R.id.i);
        j = findViewById(R.id.j);
        k = findViewById(R.id.k);
        l = findViewById(R.id.l);
        m = findViewById(R.id.m);
        n = findViewById(R.id.n);
        o = findViewById(R.id.o);
        p = findViewById(R.id.p);
        q = findViewById(R.id.q);
        r = findViewById(R.id.r);
        s = findViewById(R.id.s);
        t = findViewById(R.id.t);
        u = findViewById(R.id.u);
        v = findViewById(R.id.v);
        w = findViewById(R.id.w);
        x = findViewById(R.id.x);
        y = findViewById(R.id.y);
        z = findViewById(R.id.z);

        speak = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = speak.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        a.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });


        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        i.setOnClickListener(this);
        j.setOnClickListener(this);
        k.setOnClickListener(this);
        l.setOnClickListener(this);
        m.setOnClickListener(this);
        n.setOnClickListener(this);
        o.setOnClickListener(this);
        p.setOnClickListener(this);
        q.setOnClickListener(this);
        r.setOnClickListener(this);
        s.setOnClickListener(this);
        t.setOnClickListener(this);
        u.setOnClickListener(this);
        v.setOnClickListener(this);
        w.setOnClickListener(this);
        x.setOnClickListener(this);
        y.setOnClickListener(this);
        z.setOnClickListener(this);




    }



    private void speak(int i ) {
        String text = alphabets[i];
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

        if (view.getId() == R.id.a){
            speak(0);
        } else if (view.getId() == R.id.b){
            speak(1);
        } else if (view.getId() == R.id.c){
            speak(2);
        } else if (view.getId() == R.id.d){
            speak(3);
        } else if (view.getId() == R.id.e){
            speak(4);
        } else if (view.getId() == R.id.f){
            speak(5);
        } else if (view.getId() == R.id.g){
            speak(6);
        } else if (view.getId() == R.id.h){
            speak(7);
        } else if (view.getId() == R.id.i){
            speak(8);
        } else if (view.getId() == R.id.j){
            speak(9);
        }else if (view.getId() == R.id.k){
            speak(10);
        } else if (view.getId() == R.id.l){
            speak(11);
        } else if (view.getId() == R.id.m){
            speak(12);
        } else if (view.getId() == R.id.n){
            speak(13);
        }else if (view.getId() == R.id.o){
            speak(14);
        } else if (view.getId() == R.id.p){
            speak(15);
        } else if (view.getId() == R.id.q){
            speak(16);
        } else if (view.getId() == R.id.r){
            speak(17);
        }else if (view.getId() == R.id.s){
            speak(18);
        } else if (view.getId() == R.id.t){
            speak(19);
        } else if (view.getId() == R.id.u){
            speak(20);
        } else if (view.getId() == R.id.v){
            speak(21);
        }else if (view.getId() == R.id.w){
            speak(22);
        } else if (view.getId() == R.id.x){
            speak(23);
        } else if (view.getId() == R.id.y){
            speak(24);
        } else if (view.getId() == R.id.z){
            speak(25);
        }

    }
}