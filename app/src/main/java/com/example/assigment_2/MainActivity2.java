package com.example.assigment_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    
    Lesson[] lesson ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent  = getIntent();

        RecyclerView recycler = findViewById(R.id.recyclerView);

        String s = intent.getStringExtra("lessons");

        lesson = new Gson().fromJson(s, Lesson[].class);


        for (int i = 0; i < lesson.length; i++) {
            Log.d("mosleh", lesson[i].getTitle());
        }

        recycler.setLayoutManager(new LinearLayoutManager(this));
        CardActivity adapter = new CardActivity(lesson);
        recycler.setAdapter(adapter);
    }
}