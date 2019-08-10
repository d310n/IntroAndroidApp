package com.example.introandroidapp;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
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
        //Add a listener to the button to take you to the temp converter
        Button btnWeather=(Button) findViewById(R.id.btnWeather);
        btnWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goWeather();
            }
        });
        //Add a listener to the button to take you to the temp converter
        Button btnDraw =(Button) findViewById(R.id.btnDraw);
        btnDraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goDrawing();
            }
        });
        //Add a listener to the button to take you to the temp converter
        Button btnTicTacToe =(Button) findViewById(R.id.btnTicTacToe);
        btnTicTacToe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goTicTacToe();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private void goWeather() {
        Intent intent = new Intent(MainMenuActivity.this, WeatherActivity.class);
            this.startActivity(intent);

    }

    private void goDrawing() {
        Intent intent = new Intent(MainMenuActivity.this, MyDrawing.class);
        this.startActivity(intent);
    }

    private void goTicTacToe() {
        Intent intent = new Intent(MainMenuActivity.this, TicTacToeActivity.class);
        this.startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action bar item clicks here. The action bar will
        //automatically handle clicks on the Home/Up button, so long
        //as you specify a parent activity
        switch (item.getItemId()) {
            case R.id.mnuMain:
                startActivity(new Intent(getApplicationContext(), MainMenuActivity.class));
                return true;
            case R.id.mnuExit:
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
