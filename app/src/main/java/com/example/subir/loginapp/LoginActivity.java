package com.example.subir.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    TextView t;
    WebView browser;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Intent i = getIntent();
        String user = i.getStringExtra("username");

        t =  findViewById(R.id.loginview);
        t.setText(t.getText()+" "+user);

        browser = findViewById(R.id.webview);
        browser.loadUrl("http://www.tutorialspoint.com");

    }

    @Override
    public void onClick(View v) {

    }
}
