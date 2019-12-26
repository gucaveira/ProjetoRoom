package com.projetoroom.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.projetoroom.model.Aluno;
import com.projetoroom.room.dao.RoomAlunoDao;

@Database(entities = {Aluno.class}, version = 1, exportSchema = false)
public abstract class ProjetoDatabase extends RoomDatabase {

    public abstract RoomAlunoDao getRoomAlunoDAO();
}
