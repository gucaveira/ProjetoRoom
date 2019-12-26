package com.projetoroom.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.projetoroom.model.Aluno;
import com.projetoroom.room.dao.AlunoDao;

@Database(entities = {Aluno.class}, version = 2, exportSchema = false)
public abstract class ProjetoDatabase extends RoomDatabase {

    private static final String AGENDA_DB = "agenda.db";

    public abstract AlunoDao getRoomAlunoDAO();

    public static ProjetoDatabase getInstance(Context context) {
        return Room.databaseBuilder(context, ProjetoDatabase.class, AGENDA_DB)
                .allowMainThreadQueries()
                .build();
    }
}
