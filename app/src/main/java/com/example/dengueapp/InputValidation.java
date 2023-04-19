package com.example.dengueapp;

import android.app.Activity;
import android.content.Context;
import android.hardware.input.InputManager;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputLayout;

public class InputValidation {

    private final Context context;

    public InputValidation(Context context)
    {
        this.context = context;
    }

    public boolean isEditTextFilled(EditText ET, TextInputLayout TIL,String message)
    {
        String value= ET.getText().toString().trim();
        if(value.isEmpty())
        {
            TIL.setError(message);
            hideKeyboardFrom(ET);
            return false;


        }
        else {
            TIL.setErrorEnabled(false);
        }
        return true;
    }

    public boolean isEmailValid(EditText ET, TextInputLayout TIL,String message)
    {
        String value= ET.getText().toString().trim();
        if(value.isEmpty()|| !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()  )
        {
            TIL.setError(message);
            hideKeyboardFrom(ET);
            return false;


        }
        else {
            TIL.setErrorEnabled(false);
        }
        return true;

    }

    public boolean isPassMatch(EditText ET1,EditText ET2, TextInputLayout TIL,String message)
    {
        String value1= ET1.getText().toString().trim();
        String value2= ET2.getText().toString().trim();

        if(!value1.contentEquals(value2) )
        {
            TIL.setError(message);
            hideKeyboardFrom(ET2);
            return false;
        }
        else {
            TIL.setErrorEnabled(false);
        }
        return true;

    }

    private void hideKeyboardFrom(View view)
    {
        InputMethodManager imm= (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

    }

}
