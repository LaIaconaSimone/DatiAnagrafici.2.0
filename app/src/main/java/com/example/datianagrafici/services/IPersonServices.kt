package com.example.datianagrafici.services

import com.example.datianagrafici.entities.Persona

interface IPersonaServices {

    fun addPerson(person: Persona): Unit
    fun removePerson(person: Persona): Unit
    fun getAllPersons(): List<Persona>

}