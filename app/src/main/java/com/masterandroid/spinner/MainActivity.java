package com.masterandroid.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    String[] countryNames;
    private Spinner spinner;
    private Button button;
    private TextView textView;
    private Context mContext;
    ArrayList<String> titleArryList;
    private boolean firstSelection = true;

    private int[] flags ={R.drawable.bangladesh,R.drawable.hong_kong,R.drawable.thailand,R.drawable.cambodia,R.drawable.india,R.drawable.vieatnam,R.drawable.singapur,R.drawable.malaysia,R.drawable.indonesia};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = MainActivity.this;
        titleArryList = new ArrayList<String>();

        titleArryList.add(Constants.country1);
        titleArryList.add(Constants.country2);
        titleArryList.add(Constants.country3);
        titleArryList.add(Constants.country4);
        titleArryList.add(Constants.country5);
        titleArryList.add(Constants.country6);
        titleArryList.add(Constants.country7);
        titleArryList.add(Constants.country8);
        titleArryList.add(Constants.country9);

        countryNames = getResources().getStringArray(R.array.country_names);
        spinner = findViewById(R.id.SpinnerId);

        MyAdapter myAdapter = new MyAdapter(this,flags,countryNames);
        spinner.setAdapter(myAdapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(firstSelection==true){
                    firstSelection =false ;
                }else {
                    Intent intent = new Intent(MainActivity.this,CountryDetails.class);
                    intent.putExtra("titles",countryNames[position]);
                    intent.putExtra("flags",flags[position]);
                    intent.putExtra("details",titleArryList.get(position));
                    startActivity(intent);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
