package com.projetoroom.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.projetoroom.model.Aluno;
import com.projetoroom.model.Telefone;
import com.projetoroom.room.conversor.ConversorCalendar;
import com.projetoroom.room.conversor.ConversorTipoTelefone;
import com.projetoroom.room.dao.AlunoDao;

@Database(entities = {Aluno.class, Telefone.class}, version = 6, exportSchema = false)
@TypeConverters({ConversorCalendar.class, ConversorTipoTelefone.class})
public abstract class ProjetoDatabase extends RoomDatabase {

    private static final String AGENDA_DB = "agenda.db";

    public abstract AlunoDao getRoomAlunoDAO();

    public static ProjetoDatabase getInstance(Context context) {
        return Room.databaseBuilder(context, ProjetoDatabase.class, AGENDA_DB)
                .allowMainThreadQueries()
                .addMigrations(Migracao.getMigracao())
                .build();
    }
}
