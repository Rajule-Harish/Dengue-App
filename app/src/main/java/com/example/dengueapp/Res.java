package com.example.dengueapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dengueapp.ui.slideshow.SlideshowFragment;

public class Res extends AppCompatActivity {

    private Button btn3,btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_res);
        btn3=findViewById(R.id.button3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count.correct=0;
                Count.wrong=0;
                Intent intent1 = new Intent(Res.this, Q1.class);
                startActivity(intent1);
            }
        });

        btn4=findViewById(R.id.button4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count.correct=0;
                Count.wrong=0;
                Intent intent1 = new Intent(Res.this, UserActivity.class);
                startActivity(intent1);
            }
        });

       // TextView txtOne = (TextView) findViewById(R.id.textView15);
        String s="Correct Answers:";
       // txtOne.setText(s+Count.correct);
      //  TextView txtTwo = (TextView) findViewById(R.id.textView16);
        String s2="Wrong Answers:";

      //  txtTwo.setText(s2+Count.wrong);
      //  TextView txtThree = (TextView) findViewById(R.id.textView17);
        String s3="Final Result:";
      //  txtThree.setText(s3+Count.correct);
    }
}