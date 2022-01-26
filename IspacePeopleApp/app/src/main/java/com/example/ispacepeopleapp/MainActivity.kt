package com.example.ispacepeopleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.ispacepeopleapp.activities.SecondActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.button3)

        //android interface
        btn.setOnClickListener{
            val intent = Intent(this@MainActivity, SecondActivity:: class.java)  //this is a reference to the current activity
            startActivity(intent)  //when we start app, on create is called and the app runs.
        }

        //this is a different method
        fun GoToActivity3(btn: View){
            val intent = Intent(this@MainActivity, SecondActivity:: class.java)  //this is a reference to the current activity
            startActivity(intent)  //when we start app, on create is called and the app runs.

        }

    }


}