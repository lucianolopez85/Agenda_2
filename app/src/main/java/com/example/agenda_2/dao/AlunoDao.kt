package com.example.agenda_2.dao

import com.example.agenda_2.model.Aluno

class AlunoDao {

    var alunos: MutableList<Aluno> = mutableListOf()

    fun todos(): MutableList<Aluno> {
        return alunos
    }

    fun salva(aluno: Aluno) {
        alunos.add(aluno)
    }
}