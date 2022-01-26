package com.example.ispacepeopleapp.activities

import androidx.appcompat.app.AppCompatActivity  //it provides all information for the app
import android.os.Bundle
import com.example.ispacepeopleapp.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)   //The activity layout is connected to the activity.
                                                  // when we have red it means thee class has not been imported
    }
}