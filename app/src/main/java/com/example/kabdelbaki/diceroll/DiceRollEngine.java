package com.example.kabdelbaki.diceroll;

import java.util.ArrayList;
import java.util.Random;

import android.util.Log;

import static com.example.kabdelbaki.diceroll.MainActivity.TAG;

public class DiceRollEngine {
    private DiceRollEngine() {
    }

    public static ArrayList<Integer> executeDiceRoll(int diceSides, int diceAmount) {
        ArrayList<Integer> integerList = new ArrayList<>();
        if (diceSides < 6 || diceSides > 20) {
            Log.e(TAG, "Your dice sides may have exceeded 20 or less that 6");
        } else {
            integerList = diceRollLogic(diceSides, diceAmount);
        }
        return integerList;
    }

    private static ArrayList<Integer> diceRollLogic(int diceSides, int diceAmount) {
        ArrayList<Integer> diceRollArrayList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < diceAmount; i++) {
            int diceRollValue = rand.nextInt(diceSides) + 1;
            diceRollArrayList.add(diceRollValue);
        }
        return diceRollArrayList;
    }
}
