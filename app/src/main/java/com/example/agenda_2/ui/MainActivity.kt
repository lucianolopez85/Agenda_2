package com.example.agenda_2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.agenda_2.R
import com.example.agenda_2.dao.AlunoDao
import com.example.agenda_2.model.Aluno

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = AlunoDao()

        var listViewCreated = findViewById<ListView>(R.id.activity_lista_alunos)
        listViewCreated.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, dao.todos())
        Toast.makeText(this, dao.alunos.toString(), Toast.LENGTH_LONG).show()
    }
}