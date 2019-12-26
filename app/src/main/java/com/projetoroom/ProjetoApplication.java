package com.projetoroom;

import android.app.Application;

import com.projetoroom.dao.AlunoDAO;
import com.projetoroom.model.Aluno;


@SuppressWarnings("WeakerAccess")
public class ProjetoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        criaAlunosDeTeste();
    }

    private void criaAlunosDeTeste() {
        AlunoDAO dao = new AlunoDAO();
        dao.salva(new Aluno("Alex", "1122223333", "alex@alura.com.br"));
        dao.salva(new Aluno("Fran", "1122223333", "fran@gmail.com"));
    }
}
