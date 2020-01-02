package com.projetoroom.asynctask;

import android.os.AsyncTask;

import com.projetoroom.room.dao.AlunoDAO;
import com.projetoroom.ui.adapter.ListaAlunosAdapter;

public class BuscaAlunoTask extends AsyncTask {

    private final AlunoDAO dao;
    private final ListaAlunosAdapter adapter;

    public BuscaAlunoTask(AlunoDAO dao, ListaAlunosAdapter adapter) {
        this.dao = dao;
        this.adapter = adapter;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        adapter.atualiza(dao.todos());
        return null;
    }
}
