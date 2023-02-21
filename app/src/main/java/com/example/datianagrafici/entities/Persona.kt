package com.example.datianagrafici.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


enum class Gender { Male, Female }

@Entity
data class Persona(
    val name: String,
    val surname: String,
    val date: String,
    val city: String,
    val province: String,
    val gender: Gender,
    )
{
    @PrimaryKey(autoGenerate = true) var id: Long = 0

   override fun toString(): String {
    return "$name $surname ($date) " +
            "${if (gender == Gender.Male) 'M' else 'F'}" +
            " $city"
}
}
