package com.projetoroom.room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.projetoroom.model.Aluno;
import com.projetoroom.room.dao.AlunoDao;

@Database(entities = {Aluno.class}, version = 2, exportSchema = false)
public abstract class ProjetoDatabase extends RoomDatabase {

    private static final String AGENDA_DB = "agenda.db";

    public abstract AlunoDao getRoomAlunoDAO();

    public static ProjetoDatabase getInstance(Context context) {
        return Room.databaseBuilder(context, ProjetoDatabase.class, AGENDA_DB)
                .allowMainThreadQueries()
                .addMigrations(new Migration(1, 2) {
                    @Override
                    public void migrate(@NonNull SupportSQLiteDatabase database) {
                        database.execSQL("ALTER TABLE aluno ADD COLUMN sobrenome TEXT");
                    }
                })
                .build();
    }
}
