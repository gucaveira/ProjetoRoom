package com.projetoroom.room.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.projetoroom.model.Telefone;

@Dao
public interface TelefoneDAO {

    @Query("SELECT Telefone.* FROM Telefone JOIN Aluno ON Telefone.alunoId  = Aluno.id " +
            " WHERE Telefone.id = :alunoId LIMIT 1")
    Telefone buscaPrimeiroTelefoneDoAluno(int alunoId);
}