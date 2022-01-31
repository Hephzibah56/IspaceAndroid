package com.example.codingbootcamp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.codingbootcamp.eveningclass.EveningActivity
import com.example.codingbootcamp.morningclass.MorningActivity

class MainActivity : AppCompatActivity() {

    private lateinit var morningsec: Button
    private lateinit var eveningsec: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        morningsec = findViewById(R.id.morningsec)   //create a buttonID
        eveningsec = findViewById(R.id.eveningsec)

        morningsec.setOnClickListener {
            val intent = Intent(this, MorningActivity::class.java) //move from one activity to another
            startActivity(intent)
        }
        eveningsec.setOnClickListener {
            val intent = Intent(this, EveningActivity::class.java)
            startActivity(intent)
        }
    }
 }