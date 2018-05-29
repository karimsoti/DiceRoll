package com.example.kabdelbaki.diceroll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        Intent intent = getIntent();
        ArrayList<Integer> diceRollList = intent.getIntegerArrayListExtra("diceSidesAndAmount");


        TextView resultBox = (TextView) findViewById(R.id.diceRollResult); //R.id get resource id from xml


        for (int i = 0; i < diceRollList.size(); i++) {

            resultBox.append(diceRollList.get(i).toString());

        }

    }
}
