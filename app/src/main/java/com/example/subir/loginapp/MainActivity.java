package com.example.subir.loginapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button logBtn,rstBtn;
    EditText user,pwd;
    TextView signUp,helpText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logBtn = findViewById(R.id.btnLogin);
        rstBtn = findViewById(R.id.btnReset);

        user = findViewById(R.id.userEditText);
        pwd = findViewById(R.id.pwdEditText);

        signUp = findViewById(R.id.signUpText);
        helpText = findViewById(R.id.implicitIntentText);

        logBtn.setOnClickListener(this);
        rstBtn.setOnClickListener(this);

        signUp.setOnClickListener(this);
        helpText.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //View v points to the view which is clicked.
        Intent j = getIntent();
        String user_u = j.getStringExtra("username");
        String pwd_p = j.getStringExtra("password");
        switch (v.getId()) {
            case R.id.btnLogin:
                String username = user.getText().toString();
                String password = pwd.getText().toString();
                if (username.equals(user_u) && password.equals(pwd_p)) {
                    Toast.makeText(getApplicationContext(), "LoginSuccessful", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity.this, LoginActivity.class);
                    i.putExtra("username",username);
                    startActivity(i);
                    finish();
                } else
                    Toast.makeText(getApplicationContext(), "LoginDetailsIncorrect", Toast.LENGTH_LONG).show();
                break;

            case R.id.btnReset:
                user.setText("");
                pwd.setText("");
                break;

            case R.id.signUpText:
                Intent i = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(i);
                break;

            case R.id.implicitIntentText:
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9031738521"));
                startActivity(intent);
        }


    }
}
