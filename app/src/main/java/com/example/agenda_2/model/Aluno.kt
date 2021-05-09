package com.example.agenda_2.model

import androidx.annotation.NonNull
import java.io.Serializable


class Aluno(val nome: String,
            val cel: String,
            val email: String): Serializable {
    @NonNull
    override fun toString(): String {
        return nome
    }

}

