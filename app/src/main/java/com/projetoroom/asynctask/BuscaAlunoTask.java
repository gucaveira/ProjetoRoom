package com.projetoroom.asynctask;

import android.os.AsyncTask;

import com.projetoroom.model.Aluno;
import com.projetoroom.room.dao.AlunoDAO;
import com.projetoroom.ui.adapter.ListaAlunosAdapter;

import java.util.List;

public class BuscaAlunoTask extends AsyncTask<Void, Void, List<Aluno>> {

    private final AlunoDAO dao;
    private final ListaAlunosAdapter adapter;

    public BuscaAlunoTask(AlunoDAO dao, ListaAlunosAdapter adapter) {
        this.dao = dao;
        this.adapter = adapter;
    }

    @Override
    protected List<Aluno> doInBackground(Void... voids) {
        return dao.todos();
    }

    @Override
    protected void onPostExecute(List<Aluno> todosAlunos) {
        super.onPostExecute(todosAlunos);
        adapter.atualiza(todosAlunos);
    }
}
