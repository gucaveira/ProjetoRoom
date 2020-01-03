package com.projetoroom.asynctask;

import android.os.AsyncTask;

import com.projetoroom.model.Aluno;
import com.projetoroom.model.Telefone;
import com.projetoroom.model.TipoTelefone;
import com.projetoroom.room.dao.AlunoDAO;
import com.projetoroom.room.dao.TelefoneDAO;

import java.util.List;

public class EditaAlunoTask extends AsyncTask<Void, Void, Void> {

    private final Aluno aluno;
    private final AlunoDAO alunoDAO;
    private final TelefoneDAO telefoneDAO;
    private final Telefone telefoneFixo;
    private final Telefone telefoneCelular;
    private final List<Telefone> telefonesDoAluno;
    private final AlunoEditadoListener listener;

    public EditaAlunoTask(Aluno aluno, AlunoDAO alunoDAO, TelefoneDAO telefoneDAO,
                          Telefone telefoneFixo, Telefone telefoneCelular, List<Telefone> telefonesDoAluno, AlunoEditadoListener listener) {
        this.aluno = aluno;
        this.alunoDAO = alunoDAO;
        this.telefoneDAO = telefoneDAO;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.telefonesDoAluno = telefonesDoAluno;
        this.listener = listener;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        alunoDAO.edita(aluno);
        vinculaAlunoComTelefone(aluno.getId(), telefoneFixo, telefoneCelular);
        atualizaIdsDosTelefones(telefoneFixo, telefoneCelular);
        telefoneDAO.atualiza(telefoneFixo, telefoneCelular);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        listener.quandoEditado();
    }

    private void atualizaIdsDosTelefones(Telefone telefoneFixo, Telefone telefoneCelular) {
        for (Telefone telefone :
                telefonesDoAluno) {
            if (telefone.getTipo() == TipoTelefone.FIXO) {
                telefoneFixo.setId(telefone.getId());
            } else {
                telefoneCelular.setId(telefone.getId());
            }
        }
    }

    private void vinculaAlunoComTelefone(int alunoId, Telefone... telefones) {
        for (Telefone telefone :
                telefones) {
            telefone.setAlunoId(alunoId);
        }
    }

    public interface AlunoEditadoListener {
        void quandoEditado();
    }

}
