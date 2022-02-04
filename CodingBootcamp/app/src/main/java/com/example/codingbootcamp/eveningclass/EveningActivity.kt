package com.example.codingbootcamp.eveningclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.codingbootcamp.R
import com.example.codingbootcamp.adapter.StudentsAdapter
import com.example.codingbootcamp.data.StudentsData
import com.example.codingbootcamp.utils.Constants

class EveningActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_evening2)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Evening Students")

        recyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val learnersList = ArrayList<StudentsData>()

        learnersList.add(
            StudentsData(
                "KWADWO", "Busumtwi", "kwadwobusumtwi@gmail.com", "Male",
                "Backend Developer", "0545644173", "Accra", Constants.KWADWO
            )
        )

        learnersList.add(
            StudentsData(
                "Olorunfemi", "Oyewole", "eliasikechi14@gmail.com", "Male",
                "Programmer/Graphic Designer", "0545565901", "Accra", Constants.FEMI
            )
        )

        learnersList.add(
            StudentsData(
                "Hephzibah", "Emereole", "hephzibahemereole@gmail.com", "Female",
                "Student", "0279542753", "Berekuso", Constants.ZIBAH
            )
        )

        learnersList.add(
            StudentsData(
                "Fatimah ",
                "Adam",
                "adamfatima2557@gmail.com",
                "Female",
                "Student of the  University for development Studies(UDS)",
                "0201112557",
                "Tema",
                Constants.FATIMAH
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


                val intent = Intent(this@EveningActivity, LearnerProfileActivity::class.java)
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
