package com.projetoroom.asynctask;

import android.os.AsyncTask;

import com.projetoroom.model.Aluno;
import com.projetoroom.room.dao.AlunoDAO;
import com.projetoroom.ui.adapter.ListaAlunosAdapter;

public class RemoverAlunoTask extends AsyncTask<Void, Void, Void> {

    private final Aluno aluno;
    private final AlunoDAO dao;
    private final ListaAlunosAdapter adapter;

    public RemoverAlunoTask(Aluno aluno, AlunoDAO dao, ListaAlunosAdapter adapter) {
        this.aluno = aluno;
        this.dao = dao;
        this.adapter = adapter;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        dao.remove(aluno);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        adapter.remove(aluno);
    }
}
