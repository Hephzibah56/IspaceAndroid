package com.example.codingbootcamp.morningclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import com.example.codingbootcamp.eveningclass.LearnerProfileActivity
import com.example.codingbootcamp.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codingbootcamp.adapter.StudentsAdapter
import com.example.codingbootcamp.data.StudentsData
import com.example.codingbootcamp.utils.Constants

class MorningActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_morning)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Morning Students")

        val recyclerView = findViewById(R.id.recyclerViewAm)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val learnersList = ArrayList<StudentsData>()

        learnersList.add(
            StudentsData(
                "Jeffrey", "Asare", "jeffrey@gmail.com", "Male",
                "Data scientist", "056789234", "Accra", Constants.JEFFREY
            )
        )

        learnersList.add(
            StudentsData(
                "Claudia", "Boamah", "claudia@gmail.com", "Female",
                "Front end", "027564894", "Accra", Constants.CLAUDIA
            )
        )

        learnersList.add(
            StudentsData(
                "Albert", "Osei", "albertosei@gmail.com", "Male",
                "Freelancer", "0245664894", "Accra", Constants.ALBERT
            )
        )

        val adapta = StudentsAdapter(this, learnersList, object : StudentsAdapter.HandleLearnerClick {
            override fun onLearnerClick(position: Int) {
                val allLearner = learnersList[position]
                val alllearner2 = learnersList[position]
                val fName: String = allLearner.FirstName
                val lName: String = allLearner.LastName
                val email: String = allLearner.email
                val gender: String = allLearner.gender
                val profession: String = allLearner.profession
                val learnerImag: Int = allLearner.profileImg
                val phoneNumb: String = allLearner.phoneNumber


                val intent = Intent(this@MorningActivity, LearnerProfileActivity::class.java)
                intent.putExtra("fname", fName)
                intent.putExtra("lname", lName)
                intent.putExtra("email", email)
                intent.putExtra("gender", gender)
                intent.putExtra("phone", phoneNumb)
                intent.putExtra("profession", profession)
                intent.putExtra("learnerImg", learnerImag)
                intent.putExtra("AM", "AM")
                startActivity(intent)
            }

        })

        recyclerView.adapter = adapta
    }
}
