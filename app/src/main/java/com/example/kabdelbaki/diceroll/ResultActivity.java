package com.example.kabdelbaki.diceroll;

import java.util.ArrayList;
import java.util.Arrays;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        ArrayList<Integer> diceRollList = intent.getIntegerArrayListExtra("diceSidesAndAmount");
        String diceRollText = "got null";
        if (diceRollList != null) {
            diceRollText = Arrays.toString(diceRollList.toArray());
        }

        TextView resultBox = (TextView) findViewById(R.id.diceRollResult); //R.id get resource id from xml
        if (resultBox != null) {
            resultBox.setText(diceRollText);
        }
    }
}
