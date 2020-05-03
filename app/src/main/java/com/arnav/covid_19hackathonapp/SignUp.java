package com.arnav.covid_19hackathonapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {
    TextInputLayout regName, regUser, regEmail, regPhone, regPassword;
    Button regBtn, regToLoginBtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Hooks
        regName = findViewById(R.id.name);
        regUser = findViewById(R.id.username_reg);
        regPassword = findViewById(R.id.password_reg);
        regEmail = findViewById(R.id.email);
        regPhone = findViewById(R.id.phoneNo);
        regBtn = findViewById(R.id.registerUser);
        regToLoginBtn = findViewById(R.id.sign_up_to_in);

        regBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateName() | !validatePassword() | !validatePhone() | !validateEmail() | !validateUser()) {
                    return;
                }
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Users");

                //Get all values
                String name = regName.getEditText().getText().toString();
                String username = regUser.getEditText().getText().toString();
                String password = regPassword.getEditText().getText().toString();
                String email = regEmail.getEditText().getText().toString();
                String phoneNumber = regPhone.getEditText().getText().toString();


                FirebaseUserStorage userStorage = new FirebaseUserStorage(name, username, email, phoneNumber, password);
                reference.child(phoneNumber).setValue(userStorage);

                Intent intent = new Intent(getApplicationContext(), Login.class);
                //intent.putExtra("phoneNumber", phoneNumber);
                startActivity(intent);
                finish();

            }
        });
    }

    private Boolean validateName() {
        String value = regName.getEditText().getText().toString();

        if (value.isEmpty()) {
            regName.setError("Field is Empty");
            return false;
        } else {
            regName.setError(null);
            regName.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateUser() {
        String userval = regUser.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";
        if (userval.isEmpty()) {
            regUser.setError("Field is Empty");
            return false;
        } else if (userval.length() >= 15) {
            regUser.setError("Username is too Long");
            return false;
        } else if (userval.length() <= 4) {
            regUser.setError("Username is too Short");
            return false;
        } else if (!userval.matches(noWhiteSpace)) {
            regUser.setError("White Spaces are not allowed");
            return false;
        } else {
            regUser.setError(null);
            regUser.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePassword() {
        String val = regPassword.getEditText().getText().toString();

        if (val.isEmpty()) {
            regPassword.setError("Field cannot be empty");
            return false;
        } else {
            regPassword.setError(null);
            regPassword.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateEmail() {
        String val = regEmail.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            regEmail.setError("Field cannot be empty");
            return false;
        } else if (!val.matches(emailPattern)) {
            regEmail.setError("Invalid email address");
            return false;
        } else {
            regEmail.setError(null);
            regEmail.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePhone() {
        String val = regPhone.getEditText().getText().toString();

        if (val.isEmpty()) {
            regPhone.setError("Field cannot be empty");
            return false;
        } else {
            regPhone.setError(null);
            regPhone.setErrorEnabled(false);
            return true;
        }
    }
}
