package com.example.fetchstaticdata.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.fetchstaticdata.R

class HomeViewModel (app:Application) : AndroidViewModel(app) {
    init {
        val text = FileHelper.getTextFromResources(app, R.raw.learners)
        // val text = FileHelper.getTextFromAssets(app, "learners.json")
         Log.d("DATA", text)  //displays text to the console
        //parseText(text)
    }
}