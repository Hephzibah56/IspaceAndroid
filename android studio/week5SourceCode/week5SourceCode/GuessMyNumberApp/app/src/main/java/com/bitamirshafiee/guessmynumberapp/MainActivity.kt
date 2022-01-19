package com.bitamirshafiee.guessmynumberapp

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
  private lateinit var question_text_view : TextView
  private lateinit var result_text_view : TextView
    var number : Int = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        question_text_view = findViewById(R.id.question_text_view)
        question_text_view = findViewById(R.id.result_text_view)

        printTheQuestion()

    }

    fun clickDownwardArrow(view : View){

        if (number == 5){
            guessTheNumber(3)
        }else if (number == 3){
            guessTheNumber(2)
        }else if(number == 2){
            guessTheNumber(1)
        }else if (number == 8){
            guessTheNumber(7)
        }else if (number == 7){
            guessTheNumber(6)
        }
    }

    fun clickSuccess(view : View){

        question_text_view.visibility = View.INVISIBLE
        result_text_view.visibility = View.VISIBLE
        result_text_view.text = String.format(resources.getString(R.string.str_success), number)
    }

    fun clickUpwardArrow(view : View){

        if (number == 3){
            guessTheNumber(4)
        }else if (number == 5){
            guessTheNumber(8)
        }else if (number == 8){
            guessTheNumber(9)
        }else if (number == 9){
            guessTheNumber(10)
        }

    }

    fun clickResetButton(view : View){

        result_text_view.visibility = View.INVISIBLE
        question_text_view.visibility = View.VISIBLE
        number = 5
        printTheQuestion()

    }

    private fun printTheQuestion(){
        question_text_view.text = String.format(resources.getString(R.string.str_question), number)
    }

    private fun guessTheNumber(myNumber : Int){
        number = myNumber
        printTheQuestion()
    }

}