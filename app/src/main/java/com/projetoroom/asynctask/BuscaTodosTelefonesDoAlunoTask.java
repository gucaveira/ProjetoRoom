package com.projetoroom.asynctask;

import android.os.AsyncTask;

import com.projetoroom.model.Aluno;
import com.projetoroom.model.Telefone;
import com.projetoroom.room.dao.TelefoneDAO;

import java.util.List;

public class BuscaTodosTelefonesDoAlunoTask extends AsyncTask<Void, Void, List<Telefone>> {

    private final TelefoneDAO telefoneDAO;
    private final Aluno aluno;
    private final TelefonesDoAlunoEncontradoListener listener;

    public BuscaTodosTelefonesDoAlunoTask(TelefoneDAO telefoneDAO, Aluno aluno,
                                          TelefonesDoAlunoEncontradoListener listener) {
        this.telefoneDAO = telefoneDAO;
        this.aluno = aluno;
        this.listener = listener;
    }

    @Override
    protected List<Telefone> doInBackground(Void... voids) {
        return telefoneDAO.buscaTodosTelefonesDoAluno(aluno.getId());
    }

    @Override
    protected void onPostExecute(List<Telefone> telefones) {
        super.onPostExecute(telefones);
        listener.quandoEcontrado(telefones);
    }

    public interface TelefonesDoAlunoEncontradoListener {
        void quandoEcontrado(List<Telefone> telefones);
    }
}
