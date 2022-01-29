package com.example.codingbootcamp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.codingbootcamp.R
import com.example.codingbootcamp.data.StudentsData

class StudentsAdapter(
    private val context: Context,
    private val learnersList: List<StudentsData>,
    private val handleLearnerClick: HandleLearnerClick
): RecyclerView.Adapter<StudentsAdapter.StudentsViewHolder>() {

    //why interface?
    interface HandleLearnerClick {
        fun onLearnerClick(position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsViewHolder {
        val rootView = LayoutInflater.from(context).inflate(R.layout.learner_row_data,parent,false)
        return  StudentsViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: StudentsViewHolder, position: Int) {
        val dataPosition = learnersList[position]

        holder.first_name.text = dataPosition.FirstName
        holder.learnerClick.setOnClickListener {
            handleLearnerClick.onLearnerClick(position)
        }

    }
        class StudentsViewHolder (LearnerView: View):RecyclerView.ViewHolder(LearnerView){
            val learnerClick: CardView = LearnerView.findViewById(R.id.relaytiveLayout)
            val imgUrl: ImageView = LearnerView.findViewById(R.id.imageView)
            val first_name: TextView = LearnerView.findViewById(R.id.textView)

        }

    override fun getItemCount(): Int {
        return learnersList.size
    }
}