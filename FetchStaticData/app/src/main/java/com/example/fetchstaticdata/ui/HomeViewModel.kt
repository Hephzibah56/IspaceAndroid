package com.example.fetchstaticdata.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.fetchstaticdata.R
import com.example.fetchstaticdata.data.LearnersRepository

class HomeViewModel (app:Application) : AndroidViewModel(app) {
    private val dataRepo = LearnersRepository()

    init {
        val learnersData = dataRepo.getLearnersData(app)

        for (learners in learnersData){
            Log.i("DATA","${learners.FirstName}(\$${learners.Gender})")
        }
    }
}