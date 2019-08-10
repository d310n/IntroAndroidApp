package com.example.introandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class WeatherActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    //Declare variables
    private RadioButton btnFah;
    private RadioButton btnCel;
    private RadioButton btnKel;
    private EditText txtInputTemp;
    private TextView lblOutputDegF;
    private TextView lblOutputDegC;
    private TextView lblOutputDegK;
    private Button btnConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        //set listener
        RadioGroup tempGroup = (RadioGroup) findViewById(R.id.tempGroup);
        tempGroup.setOnCheckedChangeListener(this);

        btnConvert = (Button) findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View view) {

        //Get resources for radio buttons, text boxes, and labels
        btnFah = (RadioButton) findViewById(R.id.btnDegF);
        btnCel = (RadioButton) findViewById(R.id.btnDegC);
        btnKel = (RadioButton) findViewById(R.id.btnDegK);
        txtInputTemp = (EditText) findViewById(R.id.txtInputTemp);
        lblOutputDegF = (TextView) findViewById(R.id.lblOutputDegF);
        lblOutputDegC = (TextView) findViewById(R.id.lblOutputDegC);
        lblOutputDegK = (TextView) findViewById(R.id.lblOutputDegK);

        //Convert the input temperature to double
        double temp = Double.parseDouble(String.valueOf(txtInputTemp.getText()));
        double answer = 0;

        //If the user chooses fahrenheit, convert to celsius and kelvin and display in those text boxes
        if (btnFah.isChecked()) {
            lblOutputDegF.setText(temp + " degrees F");
            lblOutputDegC.setText((Math.round((temp - 32) * 5 / 9 * 100.0) / 100.0) + " degrees C");
            lblOutputDegK.setText((Math.round((temp + 459.67) * 5 / 9 * 100.0) / 100.0) + " degrees K");
            answer = (temp - 32) * 5 / 9;
        }

        //If the user chooses Celsius, convert to fahrenheit and kelvin and display in those text boxes
        if (btnCel.isChecked()) {
            lblOutputDegF.setText((Math.round((temp * 9) / 5 + 32) * 100.0) + " degrees F");
            lblOutputDegC.setText(temp + " degrees C");
            lblOutputDegK.setText((Math.round((temp + 273.15) * 100.0) / 100.0) + " degrees K");
            answer = temp;
        }

        //If the user chooses Kelvin, convert fahrenheit and Celsius and display in those text boxes
        if (btnKel.isChecked()) {
            lblOutputDegF.setText((Math.round((temp * 9 / 5 - 459.67) * 100.0) / 100.0) + " degrees F");
            lblOutputDegC.setText((Math.round((temp - 273.15) * 100.0) / 100.0) + " degrees C");
            lblOutputDegK.setText(temp + " degrees K");
            answer = temp - 273.15;
        }

        displayToast(answer);

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        TextView lblOutput = (TextView) findViewById(R.id.lblOutput);
        switch (checkedId) {
            case R.id.btnDegF:
                lblOutput.setText("You chose Fahrenheit");
                break;
            case R.id.btnDegC:
                lblOutput.setText("You chose Celsius");
                break;
            case R.id.btnDegK:
                lblOutput.setText("You chose Kelvin");
                break;
        }
    }

    private void displayToast(double temperature) {
        if (temperature > 50)
            Toast.makeText(this, "Wow it's hot outside!", Toast.LENGTH_LONG).show();
        else if (temperature > 20)
            Toast.makeText(this, "Nice weather we are having", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Brrrrr - it's cold out!", Toast.LENGTH_LONG).show();
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