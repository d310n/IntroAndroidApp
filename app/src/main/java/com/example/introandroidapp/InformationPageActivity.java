package com.example.introandroidapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class InformationPageActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnSave;
    Spinner spnSeason;
    SeekBar skbTemp;
    Switch swchAllergy;
    TextView lblSeekValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_page);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        spnSeason = (Spinner) findViewById(R.id.spnSeason);
        skbTemp = (SeekBar) findViewById(R.id.skbTemp);
        swchAllergy = (Switch) findViewById(R.id.swchAllergy);
        lblSeekValue = (TextView) findViewById(R.id.lblSeekValue);
        btnSave = (Button) findViewById(R.id.btnSave);

        btnSave.setOnClickListener(this);
        skbTemp.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String display = String.valueOf(progress);
                lblSeekValue.setText(display);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekbar){

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public void onClick(View v){
        String season, allergies;
        int temperature;
        season = spnSeason.getSelectedItem().toString();
        temperature=skbTemp.getProgress();
        allergies = (String) (swchAllergy.isChecked() ? swchAllergy
                    .getTextOn() : swchAllergy.getTextOff()); //if the switch is on then the user has allergies
        Intent intent = new Intent(InformationPageActivity.this, InformationResultsActivity.class); //pass information to the results activity
        intent.putExtra("season", season);
        intent.putExtra("temperature", temperature);
        intent.putExtra("allergies", allergies);
        this.startActivity(intent);
    }

}
