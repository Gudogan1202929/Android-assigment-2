package com.example.assigment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    private Animation top, bottom;
    private TextView txt;
    private ImageView img;

    public Lesson[] lessons= new Lesson[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();
        setupSharedPrefs();


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        txt.setAnimation(bottom);
        img.setAnimation(top);
        Handler handler = new Handler();
        checkPrefs();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Gson gson = new Gson();
                String s = gson.toJson(lessons);
                intent.putExtra("lessons", s);
                startActivity(intent);
                finish();
            }
        }, 5000);

    }

    private void setupSharedPrefs() {
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    private void setupViews() {
        txt = findViewById(R.id.txt);
        img = findViewById(R.id.img);
        top = AnimationUtils.loadAnimation(this, R.anim.top_anim);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
    }

    private void checkPrefs() {
        if (!prefs.contains("lessons")){
            lessons = FromWebServes.GetData();
            Gson gson = new Gson();
            String s = gson.toJson(lessons);
            editor.putString("lessons", s);
            editor.commit();
        }
        else {
            Gson gson = new Gson();
            String s = prefs.getString("lessons", "");
             lessons =  gson.fromJson(s, Lesson[].class);
        }
    }
}