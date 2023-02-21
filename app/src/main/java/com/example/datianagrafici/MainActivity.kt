package com.example.datianagrafici

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.datianagrafici.adapters.PersonaAdapter
import com.example.datianagrafici.dao.PersonaDatabase
import com.example.datianagrafici.services.PersonaService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener {
            val intent = Intent(this, NewPerson::class.java)
            this.startActivity(intent)
        }
        Room.databaseBuilder(this, PersonaDatabase::class.java, "persona").apply {

        }
        val perServ = PersonaService()

        findViewById<RecyclerView>(R.id.listView).apply {
            layoutManager = LinearLayoutManager(context)

        }
    }

    override fun onResume() {
        super.onResume()
        runOnUiThread {
            Executors.newSingleThreadExecutor().execute {
                findViewById<RecyclerView>(R.id.listView).adapter =
                    Room.databaseBuilder(this, PersonaDatabase::class.java, "persona").build().let {
                        PersonaAdapter(it.getPersonaDao().getAllPerson())
                    }
            }
        }
    }
}