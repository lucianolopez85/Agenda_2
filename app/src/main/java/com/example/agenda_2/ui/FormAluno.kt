package com.example.agenda_2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.agenda_2.R
import com.example.agenda_2.dao.AlunoDao
import com.example.agenda_2.model.Aluno
import kotlinx.android.synthetic.main.activity_form_aluno.*
import org.w3c.dom.Text
import java.io.Serializable

class FormAluno : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_aluno)

        setTitle("Novo Aluno")
        val dao = AlunoDao()

        val nomeTextView: TextView = findViewById(R.id.nome)
        val celTextView: TextView = findViewById<EditText>(R.id.cel)
        val emailTextView: TextView = findViewById<EditText>(R.id.email)

        val btnSalvarView = findViewById<Button>(R.id.btn_salvar)
        btnSalvarView.setOnClickListener {
            var nome = nomeTextView.editableText.toString()
            var cel = celTextView.editableText.toString()
            var email = emailTextView.editableText.toString()

            var alunoCriado = Aluno(nome, cel, email)

            dao.salva(alunoCriado)

            startActivity(Intent(this, ListaAlunos::class.java))

            val dados = Intent()
            val aluno:Aluno = dados.getSerializableExtra("aluno") as Aluno
            nomeTextView.setText(aluno.nome)
            celTextView.setText(aluno.cel)
            emailTextView.setText(aluno.email)
        }

    }
}



