package com.projetoroom.asynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import com.projetoroom.model.Telefone;
import com.projetoroom.room.dao.TelefoneDAO;

public class BuscaPrimeiroTelefoneDoAlunoTask extends AsyncTask<Void, Void, Telefone> {


    private final int alunoId;
    private final TextView campoTelefone;
    private final TelefoneDAO dao;

    public BuscaPrimeiroTelefoneDoAlunoTask(int alunoId, TextView campoTelefone, TelefoneDAO dao) {
        this.alunoId = alunoId;
        this.campoTelefone = campoTelefone;
        this.dao = dao;
    }

    @Override
    protected Telefone doInBackground(Void... voids) {
        return dao.buscaPrimeiroTelefoneDoAluno(alunoId);
    }

    @Override
    protected void onPostExecute(Telefone primeiroTelefone) {
        super.onPostExecute(primeiroTelefone);
        campoTelefone.setText(primeiroTelefone.getNumero());
    }
}