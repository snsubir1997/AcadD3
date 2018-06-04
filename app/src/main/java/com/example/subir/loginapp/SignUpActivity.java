package com.example.subir.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    Button b;
    EditText e1,e2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        b = findViewById(R.id.signUpSubmit);
        e1 = findViewById(R.id.usernameField);
        e2 = findViewById(R.id.pwdField);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String username = e1.getText().toString();
        String password = e2.getText().toString();

        switch (v.getId()){
            case R.id.signUpSubmit:
                Toast.makeText(getApplicationContext(),"Sign Up Success",Toast.LENGTH_LONG).show();
                Intent i = new Intent(SignUpActivity.this,MainActivity.class);
                i.putExtra("username",username);
                i.putExtra("password",password);
                startActivity(i);
                break;
        }
    }
}
