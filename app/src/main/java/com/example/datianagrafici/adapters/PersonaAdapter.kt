package com.example.datianagrafici.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.datianagrafici.R
import com.example.datianagrafici.entities.Persona

class PersonaViewHolder(view: View) : RecyclerView.ViewHolder(view)  {

    private val nameView: TextView
    private val dataView: TextView
    private val cityView: TextView
    private val genderView: TextView
    private val surnameView: TextView
    private val provinciaView: TextView




    init {
        nameView = view.findViewById(R.id.textView_person_Name)
        dataView = view.findViewById(R.id.text_view_person_data)
        cityView = view.findViewById(R.id.text_view_citta)
        genderView = view.findViewById(R.id.text_view_person_sesso)
        surnameView = view.findViewById(R.id.textView_person_surnameName)
        provinciaView = view.findViewById(R.id.text_view_provincia)
    }

    fun showPersona(persona: Persona) {
        nameView.text = persona.name
        dataView.text = persona.date
        cityView.text = persona.city
        genderView.text = persona.gender.toString()
        surnameView.text = persona.surname
        provinciaView.text = persona.province
    }
}

class PersonaAdapter(private val model: List<Persona>) : RecyclerView.Adapter<PersonaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val template = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_item_person, parent, false)
        return PersonaViewHolder(template)
    }

    override fun getItemCount(): Int = model.size

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        holder.showPersona(model[position])
    }

}