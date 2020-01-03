package com.projetoroom.asynctask;

import com.projetoroom.model.Aluno;
import com.projetoroom.model.Telefone;
import com.projetoroom.room.dao.AlunoDAO;
import com.projetoroom.room.dao.TelefoneDAO;

public class SalvaAlunoTask extends BaseAlunoComTelefoneTask {

    private final Aluno aluno;
    private final AlunoDAO alunoDAO;
    private final TelefoneDAO telefoneDAO;
    private final Telefone telefoneFixo;
    private final Telefone telefoneCelular;

    public SalvaAlunoTask(Aluno aluno, AlunoDAO alunoDAO,
                          TelefoneDAO telefoneDAO,
                          Telefone telefoneFixo, Telefone telefoneCelular, FinalizadaListener listener) {
        super(listener);
        this.aluno = aluno;
        this.alunoDAO = alunoDAO;
        this.telefoneDAO = telefoneDAO;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        int alunoId = alunoDAO.salva(aluno).intValue();
        vinculaAlunoComTelefone(alunoId, telefoneFixo, telefoneCelular);
        telefoneDAO.salva(telefoneFixo, telefoneCelular);
        return null;
    }
}