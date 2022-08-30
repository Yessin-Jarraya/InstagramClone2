package com.example.instagramclone2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.parse.Parse;

import androidx.appcompat.app.AppCompatActivity;

public class LogInto extends AppCompatActivity implements View.OnClickListener {
    private EditText edtLogInName,edtLogInPassword;
    private Button btnSignUp2,btnLogIn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginto);
        edtLogInName = findViewById(R.id.edtLogInName);
        edtLogInPassword = findViewById(R.id.edtLogInPassword);
        btnSignUp2 = findViewById(R.id.btnLogIn2);
        btnLogIn2 = findViewById(R.id.btnLogIn2);
        btnSignUp2.setOnClickListener(this);
        btnLogIn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignUp2:

                break;
            case R.id.btnLogIn2:
                break;
        }

    }
}