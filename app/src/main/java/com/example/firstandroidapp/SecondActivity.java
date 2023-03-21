package com.example.firstandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView textViewName, textViewAge, textViewGender;
    Button buttonChangeBackground;
    Button buttonToThirdActivity;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewName = findViewById(R.id.textViewName);
        textViewAge = findViewById(R.id.textViewAge);
        textViewGender = findViewById(R.id.textViewGender);
        buttonChangeBackground = findViewById(R.id.buttonChangeBackground);
        buttonToThirdActivity = findViewById(R.id.buttonToThirdActivity);
        relativeLayout = findViewById(R.id.relativeLayout);

        Bundle bundle = getIntent().getExtras();

        String name = bundle.getString("name");
        int age = bundle.getInt("age");
        String gender = bundle.getString("gender");

        textViewName.append(name);
        textViewAge.append(Integer.toString(age));
        textViewGender.append(gender);

        Random random = new Random();

        buttonChangeBackground.setOnClickListener(v -> {
            relativeLayout.setBackgroundColor(random.nextInt());
        });

        buttonToThirdActivity.setOnClickListener(v -> {
            startActivity(new Intent(this, ThirdActivity.class));
        });
    }
}