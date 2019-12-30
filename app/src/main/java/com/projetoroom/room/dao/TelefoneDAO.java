package com.projetoroom.room.dao;

import androidx.room.Dao;

import com.projetoroom.model.Telefone;

@Dao
public interface TelefoneDAO {
    Telefone buscaPrimeiroTelefoneDoAluno();
}