package com.example.datianagrafici.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.datianagrafici.entities.Persona

@Dao
interface PersonaDao {

    // Salva un oggetto Persona nel database
    @Insert
    fun save(persona: Persona)

    // Ottiene tutti gli oggetti Persona dal database
    @Query("SELECT * FROM Persona ")
    fun getAllPerson(): List<Persona>


}