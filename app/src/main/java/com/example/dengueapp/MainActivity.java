package com.example.dengueapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    TextInputLayout nml,eml,phl,psl,cpsl;
    EditText nme,eme,phe,pse,cpse;
    Button register;
    TextView already_ac;

    private databaseHelper databaseHelper;
    private InputValidation inputValidation;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nml = (TextInputLayout) findViewById(R.id.Name);
        eml = (TextInputLayout) findViewById(R.id.Email);
        phl = (TextInputLayout) findViewById(R.id.phone);
        psl = (TextInputLayout) findViewById(R.id.Pass);
        cpsl = (TextInputLayout) findViewById(R.id.ConPass);

        nme = (EditText) findViewById(R.id.editName);
        eme = (EditText) findViewById(R.id.editEmail);
        phe = (EditText) findViewById(R.id.editPhone);
        pse = (EditText) findViewById(R.id.editPass);
        cpse = (EditText) findViewById(R.id.editConPass);

        register=(Button) findViewById(R.id.register);
        already_ac=(TextView) findViewById(R.id.textView2);

        databaseHelper= new databaseHelper(MainActivity.this);
        inputValidation=new InputValidation(MainActivity.this);





        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!inputValidation.isEditTextFilled(nme,nml,"This field is necessary"))
                {
                    return;
                }
                if(!inputValidation.isEditTextFilled(eme,eml,"This field is necessary"))
                {
                    return;
                }
                if(!inputValidation.isEmailValid(eme,eml,"Enter Valid Email"))
                {
                    return;
                }

                if(!inputValidation.isEditTextFilled(pse,psl,"This field is necessary"))
                {
                    return;
                }

                if(!inputValidation.isPassMatch(pse,cpse,cpsl,"Password Does Not Match"))
                {
                    return;
                }

                if(!databaseHelper.checkUser(eme.getText().toString().trim())){


                    String name = nme.getText().toString().trim();
                    String email= eme.getText().toString().trim();
                    String phno= phe.getText().toString().trim();
                    String pass= pse.getText().toString().trim();

                    Boolean res= databaseHelper.insert_data(name,email,phno,pass);
                    if(res)
                        Toast.makeText(getApplicationContext(),"SignUp Successful",Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(),"SignUp Not Successful",Toast.LENGTH_LONG).show();


                    emptyInputEditText();

                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);


                }
                else {

                    Toast.makeText(getApplicationContext(),"Already Signed Up!",Toast.LENGTH_LONG).show();
                    emptyInputEditText();

                }
            }
            public void emptyInputEditText() {
                nme.setText("");
                eme.setText("");
                pse.setText("");
                phe.setText("");
                cpse.setText("");


            }

        });

        already_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);

            }
        });





    }
}