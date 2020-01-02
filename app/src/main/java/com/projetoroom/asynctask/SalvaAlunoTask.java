package com.projetoroom.asynctask;

import android.os.AsyncTask;

import com.projetoroom.model.Aluno;
import com.projetoroom.model.Telefone;
import com.projetoroom.room.dao.AlunoDAO;
import com.projetoroom.room.dao.TelefoneDAO;

public class SalvaAlunoTask extends AsyncTask<Void, Void, Void> {

    private final Aluno aluno;
    private final AlunoDAO alunoDAO;
    private final TelefoneDAO telefoneDAO;
    private final Telefone telefoneFixo;
    private final Telefone telefoneCelular;
    private final QuandoAlunosSalvoLister lister;

    public SalvaAlunoTask(Aluno aluno, AlunoDAO alunoDAO,
                          TelefoneDAO telefoneDAO, Telefone telefoneFixo, Telefone telefoneCelular, QuandoAlunosSalvoLister lister) {
        this.aluno = aluno;
        this.alunoDAO = alunoDAO;
        this.telefoneDAO = telefoneDAO;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.lister = lister;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        int alunoId = alunoDAO.salva(aluno).intValue();
        vinculaAlunoComTelefone(alunoId, telefoneFixo, telefoneCelular);
        telefoneDAO.salva(telefoneFixo, telefoneCelular);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        lister.quandoSalvar();
    }

    private void vinculaAlunoComTelefone(int alunoId, Telefone... telefones) {
        for (Telefone telefone :
                telefones) {
            telefone.setAlunoId(alunoId);
        }
    }

    public interface QuandoAlunosSalvoLister {
        void quandoSalvar();
    }
}