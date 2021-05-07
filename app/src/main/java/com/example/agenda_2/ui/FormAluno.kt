package com.example.agenda_2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.agenda_2.R
import com.example.agenda_2.dao.AlunoDao
import com.example.agenda_2.model.Aluno

class FormAluno : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_aluno)

        val dao = AlunoDao()

        val nomeTextView = findViewById<EditText>(R.id.nome)
        val celTextView = findViewById<EditText>(R.id.cel)
        val emailTextView = findViewById<EditText>(R.id.email)

        val btnView = findViewById<Button>(R.id.btn_salvar)
        btnView.setOnClickListener {
            var nome = nomeTextView.editableText.toString()
            var cel = celTextView.editableText.toString()
            var email = emailTextView.editableText.toString()

            var aluno = Aluno(nome, cel, email)

            dao.salva(aluno)
            Toast.makeText(this, aluno.nome, Toast.LENGTH_LONG).show()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}