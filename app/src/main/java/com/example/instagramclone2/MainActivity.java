package com.example.instagramclone2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public abstract class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtSignUpName, edtSignUpPassword, edtSignUpEmail;
    private Button btnSignUp1, btnLogIn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtSignUpName = findViewById(R.id.edtSignUpName);
        edtSignUpPassword = findViewById(R.id.edtSignUpPassword);
        edtSignUpEmail = findViewById(R.id.edtSignUpEmail);
        btnSignUp1 = findViewById(R.id.btnSignUp2);
        btnLogIn1 = findViewById(R.id.btnLogIn2);
        btnSignUp1.setOnClickListener(MainActivity.this);
        btnLogIn1.setOnClickListener(MainActivity.this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignUp1:
                ParseUser appUser=new ParseUser();
                appUser.setUsername(edtSignUpName.getText().toString());
                appUser.setEmail(edtSignUpEmail.getText().toString());
                appUser.setPassword(edtSignUpPassword.getText().toString());
                appUser.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null){
                            FancyToast.makeText(MainActivity.this,  appUser.get("username")+" is signed up succesfully", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

                        }
                        else{
                            FancyToast.makeText(MainActivity.this, e.getMessage(), FancyToast.LENGTH_LONG, FancyToast.ERROR, true).show();

                        }
                    }



                });

                break;
            case R.id.btnLogIn1:
                break;
        }
    }
}