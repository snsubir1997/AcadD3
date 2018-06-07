package com.example.subir.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmActivity extends AppCompatActivity implements View.OnClickListener {

   TextView e1,e2,e3,e4,e5,e6;
   Button b1,b2;

    Intent i,j;
    String user,pwd,email,phno,country,state;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);

        j = getIntent();
        user = j.getStringExtra("username");
        pwd = j.getStringExtra("password");
        email = j.getStringExtra("email");
        phno = j.getStringExtra("phno");
        country = j.getStringExtra("country");
        state = j.getStringExtra("state");

        e1 = findViewById(R.id.cfname);
        e2 = findViewById(R.id.cfemail);
        e3 = findViewById(R.id.cfphno);
        e4 = findViewById(R.id.cfpwd);
        e5 = findViewById(R.id.cfcountry);
        e6 = findViewById(R.id.cfstate);

        b1 = findViewById(R.id.cfsubmit);
        b2 = findViewById(R.id.cfreset);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);

        e1.setText(user);
        e2.setText(email);
        e3.setText(phno);
        e4.setText(pwd);
        e5.setText(country);
        e6.setText(state);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.cfsubmit:
                i = new Intent(ConfirmActivity.this, MainActivity.class);
                i.putExtra("username", user);
                i.putExtra("password", pwd);
                Toast.makeText(getApplicationContext(),"Sign Up Success",Toast.LENGTH_SHORT).show();
                startActivity(i);
                break;
            case R.id.cfreset:
                i = new Intent(ConfirmActivity.this, SignUpActivity.class);
                i.putExtra("username", user);
                i.putExtra("email", email);
                i.putExtra("phno", phno);
                i.putExtra("country", country);
                i.putExtra("state", state);
                startActivity(i);
                break;
        }
    }
}
