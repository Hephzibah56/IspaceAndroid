package com.ghecapsi.rolldiceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

/**
 * DiceRoller demonstrates simple interactivity in an Android app.
 * It contains one button that updates a text view with a random
 * value between 1 and 6.
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // Get the Button view from the layout and assign a click
        // listener to it.
        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener {
            rollDice()
        }

        val countButton: Button = findViewById(R.id.countup_button)
        countButton.setOnClickListener { countUp() }
    }

    //method that get random number and set it on the textView
    private fun rollDice() {
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        val randomInt = (1..6).random()

        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }


    /**
     * Click listener for the countUp button.
     */
    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)

        // If text is the default "Hello World!" set that text to 1.
        if (resultText.text == "Hello World!") {
           //write code here
        } else {
            // Otherwise, increment the number up to 6.
            // The text value in resultText.text is an instance of the CharSequence class;
            // it needs to be converted to a String object before it can be converted to an int.


            //write code here

        }
    }



}