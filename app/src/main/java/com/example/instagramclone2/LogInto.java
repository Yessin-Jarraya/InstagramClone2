package com.example.instagramclone2;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.shashank.sony.fancytoastlib.FancyToast;

import androidx.appcompat.app.AppCompatActivity;

public class LogInto extends AppCompatActivity implements View.OnClickListener {

    private EditText edtLogInName, edtLogInPassword;
    private Button btnSignUp2, btnLogIn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginto);
        setTitle("LogIn");
        edtLogInName = findViewById(R.id.edtLogInName);
        edtLogInPassword = findViewById(R.id.edtLogInPassword);
        btnSignUp2 = findViewById(R.id.btnSignUp2);
        btnLogIn2 = findViewById(R.id.btnLogIn2);
        edtLogInPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN) {
                    onClick(btnLogIn2);
                }
                return false;
            }
        });
        btnSignUp2.setOnClickListener(this);
        btnLogIn2.setOnClickListener(this);
        if (ParseUser.getCurrentUser() != null) {
            ParseUser.getCurrentUser().logOut();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignUp2:
                Intent intent = new Intent(LogInto.this, MainActivity.class);
                startActivity(intent);
                finish();

                break;
            case R.id.btnLogIn2:
                if (edtLogInName.getText().toString().equals("") || edtLogInPassword.getText().toString().equals("")) {
                    FancyToast.makeText(LogInto.this, " Username, Password is required", FancyToast.LENGTH_SHORT, FancyToast.INFO, true).show();

                } else {
                    ParseUser.logInInBackground(edtLogInName.getText().toString(), edtLogInPassword.getText().toString(), new LogInCallback() {
                        @Override
                        public void done(ParseUser user, ParseException e) {
                            if (user != null && e == null) {
                                FancyToast.makeText(LogInto.this, " You Logged in successfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                                transitionToSocialMediaActivity();

                            } else {
                                FancyToast.makeText(LogInto.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();


                            }
                        }

                    });

                    break;
                }

        }
    }
    public void rootLayoutTapped(View view){
        try{
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void transitionToSocialMediaActivity() {
        Intent intent = new Intent(LogInto.this,SocialMediaActivity.class);
        startActivity(intent);
        finish();
    }

}



