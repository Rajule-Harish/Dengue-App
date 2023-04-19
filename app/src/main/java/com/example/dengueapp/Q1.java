package com.example.dengueapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Q1 extends AppCompatActivity {

    RadioButton fi, ma, st, pr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);
        fi = findViewById(R.id.radioButton);
        ma = findViewById(R.id.radioButton2);
        st = findViewById(R.id.radioButton3);
        pr = findViewById(R.id.radioButton4);
        fi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count.wrong++;

               // Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Q1.this, com.example.dengueapp.Q2.class);
                startActivity(intent);
            }
        });
        ma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count.correct++;

               // Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Q1.this, com.example.dengueapp.Q2.class);
                startActivity(intent);

            }
        });
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count.wrong++;

               // Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Q1.this, com.example.dengueapp.Q2.class);
                startActivity(intent);
            }
        });
        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count.wrong++;

              //  Toast.makeText(getApplicationContext(), "Wrong", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(Q1.this, com.example.dengueapp.Q2.class);
                startActivity(intent);
            }
        });
    }
}