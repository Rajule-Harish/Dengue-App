package com.example.dengueapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dengueapp.databinding.ActivityLoginBinding;
import com.google.android.material.textfield.TextInputLayout;

public class LoginActivity extends AppCompatActivity {

    EditText eme1,pse1;
    TextInputLayout eml1,psl1;
    private databaseHelper databaseHelper;
    private InputValidation inputValidation;
    Button login;
    TextView reg;

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        eme1 = (EditText) findViewById(R.id.editEmailId);
        pse1 = (EditText) findViewById(R.id.editPassWord);

        eml1 = (TextInputLayout) findViewById(R.id.emailId);
        psl1 = (TextInputLayout) findViewById(R.id.PassWord);

        login=(Button) findViewById(R.id.logIn);
        reg=(TextView) findViewById(R.id.textView4);

        databaseHelper= new databaseHelper(LoginActivity.this);
        inputValidation=new InputValidation(getApplicationContext());


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!inputValidation.isEditTextFilled(eme1,eml1,"This field is necessary"))
                {
                    return;
                }
                if(!inputValidation.isEmailValid(eme1,eml1,"Enter Valid Email"))
                {
                    return;
                }
                if(!inputValidation.isEditTextFilled(pse1,psl1,"This field is necessary"))
                {
                    return;
                }

                if(databaseHelper.checkUser(eme1.getText().toString().trim(), pse1.getText().toString().trim()))
                {

                    //Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                    //emptyInputEditText();
                    if(binding.radioUser.isChecked())
                    {
                        Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                        Intent accIntentUser = new Intent(getApplicationContext(), UserActivity.class);
                        startActivity(accIntentUser);
                    }

                    if(binding.radioAdmin.isChecked())
                    {
                        Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                        Intent accIntentAdmin = new Intent(getApplicationContext(), AdminActivity.class);
                        startActivity(accIntentAdmin);
                    }

                    if(binding.radioLab.isChecked())
                    {
                        Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                        Intent accIntentLab = new Intent(getApplicationContext(), LabActivity.class);
                        startActivity(accIntentLab);
                    }


                }
                else {
                    Toast.makeText(getApplicationContext(),"Incorrect userId or password",Toast.LENGTH_LONG).show();
                    eme1.setText("");
                    pse1.setText("");
                }


            }
        });
    }

    @Override   //to avoid memory Leaks
    protected void onDestroy() {
        super.onDestroy();
        binding=null;
    }
}