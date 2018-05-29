package com.example.kabdelbaki.diceroll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.submitBtn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                EditText diceSides = findViewById(R.id.diceSides);
                EditText diceAmount = findViewById(R.id.diceAmount);

//                Toast msg = Toast.makeText(getBaseContext(), diceSides.getText().toString(), Toast.LENGTH_SHORT);
//                msg.show();


                ArrayList<Integer> diceRoll = executeDiceRoll((Integer.parseInt(diceSides.getText().toString())), Integer.parseInt(diceAmount.getText().toString()));


                /*
                Create an instance of the Intent class and use the startActivity method to move to the next activity with the ArrayList Extra
                 */
                Intent myIntent = new Intent(getBaseContext(), ResultActivity.class);
                startActivity(myIntent.putIntegerArrayListExtra("diceSidesAndAmount", diceRoll));

            }
        });


    }

    /**
     * Method is used to validate the diceSides and diceAmount values, it then calls the diceRollLogic method to get the randomized dice roll
     * @param diceSides
     * @param diceAmount
     * @return
     */


    public ArrayList<Integer> executeDiceRoll(int diceSides, int diceAmount) {

        ArrayList<Integer> integerList = new ArrayList<>();

        try {
            if (diceSides == 0 || diceAmount == 0) {
                throw new Exception("Cannot be Zero");
            } else if (diceSides < 6 || diceSides > 20) {
                throw new Exception("Your dice sides may have exceeded 20 or less that 6");
            } else {
               integerList = diceRollLogic(diceSides, diceAmount);
            }
        } catch (Exception e) {

            Log.v(TAG, e.getMessage());
        }



        return integerList;

    }

    public ArrayList<Integer> diceRollLogic(int diceSides, int diceAmount) {

        ArrayList<Integer> diceRollArrayList = new ArrayList<>();
        Random rand = new Random();

        for (int i = 0; i < diceAmount; i++) {
            int diceRollValue = rand.nextInt(diceSides) + 1;
            diceRollArrayList.add(diceRollValue);
        }

        return diceRollArrayList;

    }


}
