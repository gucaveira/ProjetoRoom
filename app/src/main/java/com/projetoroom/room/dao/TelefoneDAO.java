package com.projetoroom.room.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.projetoroom.model.Telefone;

@Dao
public interface TelefoneDAO {

    @Query("SELECT * FROM Telefone WHERE alunoId = :alunoId LIMIT 1")
    Telefone buscaPrimeiroTelefoneDoAluno(int alunoId);

    @Insert
    void salva(Telefone... telefones);
}