package com.example.fetchstaticdata.data

import com.squareup.moshi.Json

data class LearnersData(

    @Json(name = "first_name") val FirstName: String,
    @Json(name = "last_name") val LastName: String,
    @Json(name = "email") val Email: String,
    @Json(name = "gender") val Gender: String,
    @Json(name = "profession") val Profession:String,
    @Json(name = "phone_number") val Number: String,
    @Json(name = "location") val Address: String,
    @Json(name = "image") val Image: Int
)
