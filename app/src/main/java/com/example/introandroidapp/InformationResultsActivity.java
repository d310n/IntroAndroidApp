package com.example.introandroidapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InformationResultsActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_results);
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

        Intent intent = getIntent();
        String season = intent.getStringExtra("season");
        int temperature = intent.getIntExtra("temperature", 70);
        String allergies = intent.getStringExtra("allergies");

        TextView txtFavoriteSeasonResults = (TextView) findViewById(R.id.txtFavoriteSeasonResults);
        TextView txtFavoriteTempResults = (TextView) findViewById(R.id.txtFavoriteTempResults);
        TextView txtAllergiesResults = (TextView) findViewById(R.id.txtAllergiesResults);
        txtFavoriteSeasonResults.setText("Your favorite season is " + season);
        txtFavoriteTempResults.setText("Your favorite temperature is " + temperature);

        //Depending on whether the allergies are yes or no determines the output of this textbox
        if(allergies.equals("Yes"))
            txtAllergiesResults.setText("Sorry that you have allergies");
        else
            txtAllergiesResults.setText("You don't have allergies");

        Button btnMain = (Button) findViewById(R.id.btnMain);
        btnMain.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goMain();
            }


        });

        }
        private void goMain() {
            Intent intent = new Intent(InformationResultsActivity.this, MainMenuActivity.class);
            this.startActivity(intent);
        }


    @Override
    public void onClick(View v){

    }
}
