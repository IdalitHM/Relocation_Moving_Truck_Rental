package com.example.relocationmovingtruckrental;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Total extends AppCompatActivity {
    double sub = .99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView totalCost = (TextView) findViewById(R.id.txtTotal);
        ImageView image = (ImageView) findViewById(R.id.imgTruckLoad);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        float decMiles = sharedPref.getFloat("key1", 0);
        boolean tenFeet = sharedPref.getBoolean("radTen", false);
        boolean sevenFeet = sharedPref.getBoolean("radSeven",false);
        boolean twentyFeet = sharedPref.getBoolean("radTwenty", false);
        double decCost;

        DecimalFormat currency = new DecimalFormat("$###,###.##");
        if (tenFeet == true) {
            decCost = (decMiles * sub) + 19.95;
            totalCost.setText("The total cost of rental is " + currency.format(decCost));
            image.setImageResource(R.drawable.ten);
        } else if (sevenFeet == true) {
            decCost = (decMiles * sub) + 29.95;
            totalCost.setText("The total cost of rental is " + currency.format(decCost));
            image.setImageResource(R.drawable.seventeen);
        }else if (twentyFeet == true) {
            decCost = (decMiles * sub) + 39.95;
            totalCost.setText("The total cost of rental is " + currency.format(decCost));
            image.setImageResource(R.drawable.twentysix);
        }else {
            totalCost.setText("Please Select correct button");
        }
    }

}
