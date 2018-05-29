package com.example.kabdelbaki.diceroll;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.submitBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText diceSidesEditText = findViewById(R.id.diceSides);
                EditText diceAmountEditText = findViewById(R.id.diceAmount);
                int diceSidesInt = 0;
                int diceAmountInt = 0;

                if (diceSidesEditText == null || diceAmountEditText == null) {
                    Toast.makeText(getApplicationContext(), "UI Error", Toast.LENGTH_LONG).show();
                } else {
                    try {
                        diceSidesInt = Integer.parseInt(diceSidesEditText.getText().toString());
                        diceAmountInt = Integer.parseInt(diceAmountEditText.getText().toString());
                    } catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Not valid numbers", Toast.LENGTH_LONG).show();
                    }
                }

                if (diceSidesInt < 1 || diceAmountInt < 1) {
                    Toast.makeText(getApplicationContext(), "Must be positive numbers", Toast.LENGTH_LONG).show();
                }

                ArrayList<Integer> diceRollResult = DiceRollEngine.executeDiceRoll(diceSidesInt, diceAmountInt);
                Intent myIntent = new Intent(getApplicationContext(), ResultActivity.class);
                startActivity(myIntent.putIntegerArrayListExtra("diceSidesAndAmount", diceRollResult));
            }
        });
    }
}
