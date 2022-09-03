package com.example.instagramclone2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public   class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtSignUpName, edtSignUpPassword, edtSignUpEmail;
    private Button btnSignUp1, btnLogIn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("SignUp");

        edtSignUpName = findViewById(R.id.edtSignUpName);
        edtSignUpPassword = findViewById(R.id.edtSignUpPassword);
        edtSignUpPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(keyCode == KeyEvent.KEYCODE_ENTER && event.getAction() == KeyEvent.ACTION_DOWN){
                    onClick(btnSignUp1);
                }
                return false;
            }
        });
        edtSignUpEmail = findViewById(R.id.edtSignUpEmail);
        btnSignUp1 = findViewById(R.id.btnSignUp1);
        btnLogIn1 = findViewById(R.id.btnLogIn1);
        btnSignUp1.setOnClickListener(MainActivity.this);
        btnLogIn1.setOnClickListener(MainActivity.this);
        if (ParseUser.getCurrentUser()!=null){
            transitionToSocialMediaActivity();

            }
        }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignUp1:
                if(edtSignUpEmail.getText().toString().equals("")||edtSignUpName.getText().toString().equals("")||edtSignUpPassword.getText().toString().equals("")){
                    FancyToast.makeText(MainActivity.this,  " Email, Username, Password is required", FancyToast.LENGTH_SHORT, FancyToast.INFO, true).show();

                } else  {
                ParseUser appUser=new ParseUser();
                appUser.setUsername(edtSignUpName.getText().toString());
                appUser.setEmail(edtSignUpEmail.getText().toString());
                appUser.setPassword(edtSignUpPassword.getText().toString());
                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null){
                            FancyToast.makeText(MainActivity.this,  appUser.get("username")+" is signed up successfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();
                            transitionToSocialMediaActivity();

                        } else{
                            FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

                        }}

                    });



                }

                break;
            case R.id.btnLogIn1:
                Intent intent = new Intent(MainActivity.this,LogInto.class);
                startActivity(intent);
                finish();

                break;
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
        Intent intent = new Intent(MainActivity.this,SocialMediaActivity.class);
        startActivity(intent);
        finish();
    }
}