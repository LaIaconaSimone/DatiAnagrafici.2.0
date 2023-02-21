package com.example.datianagrafici

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.room.Room
import com.example.datianagrafici.dao.PersonaDatabase
import com.example.datianagrafici.entities.Gender
import com.example.datianagrafici.entities.Persona
import com.example.datianagrafici.services.PersonaService
import java.util.concurrent.Executors

class NewPerson : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_person)

        val perServ = PersonaService()
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {

            val nomeIns: EditText = findViewById(R.id.nomeIns)
            val cognomeIns: EditText = findViewById(R.id.cognomeIns)
            val dataIns: EditText = findViewById(R.id.dataIns)
            val radioMaschio: RadioButton = findViewById(R.id.radioMaschio)
            val comuneIns: EditText = findViewById(R.id.comuneIns)
            val provinciaIns: EditText = findViewById(R.id.provinciaIns)


            val name: String = nomeIns.text.toString()
            val surname: String = cognomeIns.text.toString()
            val date: String = dataIns.text.toString()
            val gender: Gender = if (radioMaschio.isChecked) Gender.Male else Gender.Female
            val city: String = comuneIns.text.toString()
            val provincia: String = provinciaIns.text.toString()

            val datiNewPersona = Persona(name, surname, city, provincia, date, gender)
            Log.d("MainActivity", "datiNewPersona: $datiNewPersona")

            runOnUiThread {
                Executors.newSingleThreadExecutor().execute {
                    Room.databaseBuilder(this, PersonaDatabase::class.java, "persona").build()
                        .getPersonaDao().save(datiNewPersona)
                }.also { finish() }
            }
        }
    }
}