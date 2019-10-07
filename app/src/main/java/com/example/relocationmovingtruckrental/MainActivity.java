package com.example.relocationmovingtruckrental;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    float decMiles;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final EditText miles = (EditText) findViewById(R.id.txtMiles);
        final RadioButton tenFeet = (RadioButton) findViewById(R.id.radTen);
        final RadioButton sevenFeet = (RadioButton) findViewById(R.id.radSeven);
        final RadioButton twentyFeet = (RadioButton) findViewById(R.id.radioTwenty);
        Button button = (Button) findViewById(R.id.btnConvert);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decMiles = Float.parseFloat(miles.getText().toString());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putFloat("key1", decMiles);
                editor.putBoolean("radTen",tenFeet.isChecked()).apply();
                editor.putBoolean("radSeven",sevenFeet.isChecked()).apply();
                editor.putBoolean("radTwenty",twentyFeet.isChecked()).apply();
                editor.commit();
                startActivity(new Intent(MainActivity.this, Total.class));


            }
        });

    }


}
