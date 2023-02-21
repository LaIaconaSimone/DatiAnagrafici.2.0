package com.example.datianagrafici.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.datianagrafici.entities.Persona

//Database Room
@Database(
    version = PersonaDatabase.VERSION,
    entities = [Persona::class]
)

//Definizione  versione e il nome database
abstract class PersonaDatabase : RoomDatabase() {
    companion object {
        const val DATABASE_NAME = "persona"
        const val VERSION = 1
    }

    abstract fun getPersonaDao(): PersonaDao

}