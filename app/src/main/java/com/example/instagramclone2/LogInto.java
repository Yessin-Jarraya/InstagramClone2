package com.example.instagramclone2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

import androidx.appcompat.app.AppCompatActivity;

public class LogInto extends AppCompatActivity implements View.OnClickListener {

    private EditText edtLogInName,edtLogInPassword;
    private Button btnSignUp2,btnLogIn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginto);
        setTitle("LogIn");
        edtLogInName = findViewById(R.id.edtLogInName);
        edtLogInPassword = findViewById(R.id.edtLogInPassword);
        btnSignUp2 = findViewById(R.id.btnSignUp2);
        btnLogIn2 = findViewById(R.id.btnLogIn2);
        btnSignUp2.setOnClickListener(this);
        btnLogIn2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignUp2:
                Intent intent = new Intent(LogInto.this,MainActivity.class);
                startActivity(intent);
                finish();

                break;
            case R.id.btnLogIn2:
                ParseUser.logInInBackground(edtLogInName.getText().toString(), edtLogInPassword.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser user, ParseException e) {
                        if (user!=null && e==null){
                            FancyToast.makeText(LogInto.this,  " You Logged in successfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();


                        }
                        else {                            FancyToast.makeText(LogInto.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();


                        }
                    }

                });

                break;
        }

    }
}