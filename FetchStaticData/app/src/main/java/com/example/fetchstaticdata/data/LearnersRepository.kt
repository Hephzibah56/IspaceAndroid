package com.example.fetchstaticdata.data

import android.content.Context
import com.example.fetchstaticdata.ui.FileHelper
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class LearnersRepository {

    private val listype = Types.newParameterizedType(
        List::class.java,LearnersData::class.java
    )

    fun getLearnersData(context: Context):List<LearnersData>{
        val text = FileHelper.getTextFromAssets(context, "learners.json")
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
        val adapter: JsonAdapter<List<LearnersData>> =
            moshi.adapter(listype)
        return adapter.fromJson(text) ?: emptyList()

    }
}