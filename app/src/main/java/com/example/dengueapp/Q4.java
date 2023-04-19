package com.example.dengueapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Q4 extends AppCompatActivity {

    RadioButton fi,ma,st,pr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4);
        fi=findViewById(R.id.radioButton13);
        ma=findViewById(R.id.radioButton14);
        st=findViewById(R.id.radioButton15);
        pr=findViewById(R.id.radioButton16);
        fi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count.wrong++;

               // Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Q4.this,Q5.class);
                startActivity(intent);
            }
        });
        ma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count.correct++;

              //  Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Q4.this,Q5.class);
                startActivity(intent);
            }
        });
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count.wrong++;

              //  Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Q4.this,Q5.class);
                startActivity(intent);
            }
        });
        pr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Count.wrong++;

              //  Toast.makeText(getApplicationContext(),"Wrong",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(Q4.this,Q5.class);
                startActivity(intent);
            }
        });
    }
}