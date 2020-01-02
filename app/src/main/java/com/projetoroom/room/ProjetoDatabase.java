package com.projetoroom.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.projetoroom.model.Aluno;
import com.projetoroom.model.Telefone;
import com.projetoroom.room.converter.ConversorCalendar;
import com.projetoroom.room.converter.ConversorTipoTelefone;
import com.projetoroom.room.dao.AlunoDAO;
import com.projetoroom.room.dao.TelefoneDAO;

@Database(entities = {Aluno.class, Telefone.class}, version = 6, exportSchema = false)
@TypeConverters({ConversorCalendar.class, ConversorTipoTelefone.class})
public abstract class ProjetoDatabase extends RoomDatabase {

    private static final String AGENDA_DB = "agenda.db";

    public abstract AlunoDAO getAlunoDAO();

    public abstract TelefoneDAO getTelefoneDAO();

    public static ProjetoDatabase getInstance(Context context) {
        return Room.databaseBuilder(context, ProjetoDatabase.class, AGENDA_DB)
                .addMigrations(Migracao.getMigracao())
                .build();
    }
}
