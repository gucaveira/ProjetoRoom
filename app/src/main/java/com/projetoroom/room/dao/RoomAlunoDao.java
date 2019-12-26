package com.projetoroom.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.projetoroom.model.Aluno;

import java.util.List;

@Dao
public interface RoomAlunoDao {

    @Insert
    void salva(Aluno aluno);

    @Query("SELECT * FROM Aluno")
    List<Aluno> todos();

    @Delete
    void remove(Aluno aluno);
}
