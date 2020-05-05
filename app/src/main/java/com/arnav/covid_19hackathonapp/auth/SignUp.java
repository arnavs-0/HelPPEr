package com.arnav.covid_19hackathonapp.auth;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.arnav.covid_19hackathonapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    private static final String TAG = "SignUp";
    TextInputLayout regName, regUser, regEmail, regPhone, regPassword;
    Button regBtn, regToLoginBtn;

    FirebaseDatabase rootNode;
    DatabaseReference reference;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mAuth = FirebaseAuth.getInstance();

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
                if (!validateName() | !validatePhone() | !validateUser() | !validateEmail() | !validatePassword()) {
                    return;
                }
                validateAuth();

            }
        });
    }

    private void validateAuth() {
        String emailAuth, passwordAuth;
        emailAuth = regEmail.getEditText().getText().toString();
        passwordAuth = regPassword.getEditText().getText().toString();

        if (TextUtils.isEmpty(emailAuth)) {
            Toast.makeText(getApplicationContext(), "Please enter email...", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(passwordAuth)) {
            Toast.makeText(getApplicationContext(), "Please enter password!", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(emailAuth, passwordAuth)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            rootNode = FirebaseDatabase.getInstance();
                            reference = rootNode.getReference("Users");

                            //Get all values
                            String name = regName.getEditText().getText().toString();
                            String occ = regUser.getEditText().getText().toString();
                            String password = regPassword.getEditText().getText().toString();
                            String email = regEmail.getEditText().getText().toString();
                            String phoneNumber = regPhone.getEditText().getText().toString();


                            FirebaseUserStorage userStorage = new FirebaseUserStorage(name, occ, email, phoneNumber, password);
                            reference.child(phoneNumber).setValue(userStorage);


                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUp.this, "Auth Failed", Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }
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
        int length = val.length();

        if (val.isEmpty()) {
            regPassword.setError("Field cannot be empty");
            return false;
        } else if (length < 6) {
            regPassword.setError("Password must be at least 6 Characters");
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

    public void updateUI(FirebaseUser user) {
        if (user != null) {
            Toast.makeText(this, "You Registered Successfully", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(getApplicationContext(), Login.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Error Please Try Again", Toast.LENGTH_LONG).show();
        }
    }
}
