package com.example.agenda_2.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.agenda_2.R
import com.example.agenda_2.dao.AlunoDao
import com.example.agenda_2.model.Aluno
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaAlunos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("Lista Alunos")

        val dao = AlunoDao()
//        dao.salva(Aluno("Luciano", "4899998888", "luciano.gmail.com"))
//        dao.salva(Aluno("juliano", "4877776666", "juliano.gmail.com"))
//        dao.salva(Aluno("Leticia", "4855554444", "leticia.gmail.com"))

        val btnAdicionarView = findViewById<FloatingActionButton>(R.id.btn_adicionar)
        btnAdicionarView.setOnClickListener {
            startActivity(Intent(this, FormAluno::class.java))

        }

        configuraLista(dao)
    }

    private fun configuraLista(dao: AlunoDao) {
        val listaAlunosView = findViewById<ListView>(R.id.activity_lista_alunos)
        val alunos: List<Aluno> = dao.todos()
        listaAlunosView.adapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, alunos)
        listaAlunosView.setOnItemClickListener { parent, view, position, id ->
            var alunoEscolhido = alunos[position]
            var intent = Intent(this, FormAluno::class.java)
            intent.putExtra("aluno", alunoEscolhido)
            //para enviar dados no putExtra os dados devem ser em bits - serialize
            startActivity(intent)

//            Log.i("ALUNO", " "+alunoEscolhido)
//            Log.i("ALUNO", " position "+position+ " id "+id)
        }


    }
}