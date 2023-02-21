package com.example.datianagrafici.services

import com.example.datianagrafici.dao.PersonaDao
import com.example.datianagrafici.entities.Gender
import com.example.datianagrafici.entities.Persona

class PersonaService() : IPersonaServices {

    companion object {
        val personList: MutableList<Persona> = mutableListOf(
            Persona("Andrea", "Verdi", "Napoli", "Napoli", "01/01/01", Gender.Male),
            Persona("Simone", "Rossi", "Milano", "Milano", "02/02/02", Gender.Male),
            Persona("Michele", "Blu", "Roma", "Roma", "03/03/03", Gender.Female)
        )
    }

    override fun addPerson(person: Persona) {
        personList.add(person)
    }

    override fun removePerson(person: Persona) {
        personList.remove(person)
    }

    override fun getAllPersons(): List<Persona> = personList
}