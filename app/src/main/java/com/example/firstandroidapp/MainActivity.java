package com.example.firstandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextName, editTextAge;
    RadioGroup radioGroupGender;
    RadioButton radioButtonMale, radioButtonFemale;
    Button buttonReset, buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        buttonReset = findViewById(R.id.buttonReset);
        buttonSend = findViewById(R.id.buttonSend);

        buttonReset.setOnClickListener(v -> {
            editTextName.setText("");
            editTextAge.setText("");
            radioGroupGender.clearCheck();
        });

        buttonSend.setOnClickListener(v -> {
            String name = editTextName.getText().toString().trim();
            String age = editTextAge.getText().toString().trim();
            String gender = radioButtonMale.isChecked() ? "Male" : "Female";

            if (name.isEmpty()) {
                editTextName.setError("Name is required!");
                editTextName.requestFocus();
                return;
            }

            if (age.isEmpty()) {
                editTextAge.setError("Age is required!");
                editTextAge.requestFocus();
                return;
            }

            int intAge = Integer.parseInt(age);

            if (intAge <= 0 || intAge >= 150) {
                editTextAge.setError("Invalid age!");
                editTextAge.requestFocus();
                return;
            }

            if (!radioButtonFemale.isChecked() && !radioButtonMale.isChecked()) {
                Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();
                return;
            }

            Intent intent = new Intent(this, SecondActivity.class);

            intent.putExtra("name", name);
            intent.putExtra("age", intAge);
            intent.putExtra("gender", gender);

            startActivity(intent);
        });
    }
}