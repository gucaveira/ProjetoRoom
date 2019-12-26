package com.projetoroom;

import android.app.Application;

import androidx.room.Room;

import com.projetoroom.model.Aluno;
import com.projetoroom.room.ProjetoDatabase;
import com.projetoroom.room.dao.RoomAlunoDao;


@SuppressWarnings("WeakerAccess")
public class ProjetoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        ProjetoDatabase database = Room.databaseBuilder(
                this, ProjetoDatabase.class, "agenda.db")
                .allowMainThreadQueries()
                .build();
        RoomAlunoDao dao = database.getRoomAlunoDAO();
        dao.salva(new Aluno("Alex", "1122223333", "alex@alura.com.br"));
        dao.salva(new Aluno("Fran", "1122223333", "fran@gmail.com"));
    }
}
