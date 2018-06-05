package com.example.subir.loginapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ListScrollerActivity extends AppCompatActivity implements View.OnClickListener {

    Spinner countrySpinner,stateSpinner;
    ArrayAdapter<String> countryAdapter,stateAdapter;
    Button b;
    String cty,stte;

    String[] country = {
            "India",
            "China",
            "Pakistan",
            "Japan"
    };

    String[] IndiaStates = {"Mumbai",
            "Kerala",
            "Gujarat"};
    String ChinaStates[] = {"Qinghai",
            "Shanghai"};
    String PakistanStates[] = {"Islamabad",
            "Lahore"};
    String JapanStates[] = {"Tokyo"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_scroller);

        b = findViewById(R.id.allSubmit);
        b.setOnClickListener(this);

        countrySpinner = findViewById(R.id.countryScroller);
        countryAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_spinner_item,country);
        countrySpinner.setAdapter(countryAdapter);

        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected (AdapterView < ? > adapterView,
                                        View view,int position, long id){
                cty = country[position];
                switch (position)
                {
                    case 0:
                        stateSpinner = findViewById(R.id.stateScroller);
                        stateAdapter = new ArrayAdapter<>(getApplicationContext(),
                                android.R.layout.simple_spinner_item,IndiaStates);
                        stateSpinner.setAdapter(stateAdapter);

                        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                        {
                            @Override
                            public void onItemSelected (AdapterView < ? > adapterView,
                                                        View view,int p, long id1){
                                stte = IndiaStates[p];
                            }
                            @Override
                            public void onNothingSelected (AdapterView < ? > adapterView){

                            }
                        });
                        break;
                    case 1:
                        stateSpinner = findViewById(R.id.stateScroller);
                        stateAdapter = new ArrayAdapter<>(getApplicationContext(),
                                android.R.layout.simple_spinner_item,ChinaStates);
                        stateSpinner.setAdapter(stateAdapter);

                        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                        {
                            @Override
                            public void onItemSelected (AdapterView < ? > adapterView,
                                                        View view,int p, long id1){
                                stte = ChinaStates[p];
                            }
                            @Override
                            public void onNothingSelected (AdapterView < ? > adapterView){

                            }
                        });
                        break;
                    case 2:
                        stateSpinner = findViewById(R.id.stateScroller);
                        stateAdapter = new ArrayAdapter<>(getApplicationContext(),
                                android.R.layout.simple_spinner_item,PakistanStates);
                        stateSpinner.setAdapter(stateAdapter);

                        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                        {
                            @Override
                            public void onItemSelected (AdapterView < ? > adapterView,
                                                        View view,int p, long id1){
                                stte = PakistanStates[p];
                            }
                            @Override
                            public void onNothingSelected (AdapterView < ? > adapterView){

                            }
                        });
                        break;
                    case 3:
                        stateSpinner = findViewById(R.id.stateScroller);
                        stateAdapter = new ArrayAdapter<>(getApplicationContext(),
                                android.R.layout.simple_spinner_item,JapanStates);
                        stateSpinner.setAdapter(stateAdapter);

                        stateSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                        {
                            @Override
                            public void onItemSelected (AdapterView < ? > adapterView,
                                                        View view,int p, long id1){
                                stte = JapanStates[p];
                            }
                            @Override
                            public void onNothingSelected (AdapterView < ? > adapterView){

                            }
                        });
                        break;
                }
            }

            @Override
            public void onNothingSelected (AdapterView < ? > adapterView){

            }
        });
    }

    @Override
    public void onClick(View v) {

        Intent j = getIntent();
        String user = j.getStringExtra("username");
        String pwd = j.getStringExtra("password");
        String email = j.getStringExtra("email");
        String phno = j.getStringExtra("phno");

        switch (v.getId()){
            case R.id.signUpSubmit:
                Toast.makeText(getApplicationContext(),"Data Saved",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(ListScrollerActivity.this,ConfirmPage.class);
                i.putExtra("username",user);
                i.putExtra("password",pwd);
                i.putExtra("email",email);
                i.putExtra("phno",phno);
                i.putExtra("country",cty);
                i.putExtra("state",stte);
                startActivity(i);
                break;
    }
}
