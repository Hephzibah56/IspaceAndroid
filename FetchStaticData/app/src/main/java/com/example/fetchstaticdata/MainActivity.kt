package com.example.fetchstaticdata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.fetchstaticdata.databinding.ActivityMainBinding
import com.example.fetchstaticdata.ui.HomeFragment

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //creating a bind
         binding = ActivityMainBinding.inflate(layoutInflater)
         setContentView(binding.root)


        supportFragmentManager.commit{
            add<HomeFragment>(R.id.container, null)
        }
    }
}