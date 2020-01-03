package com.projetoroom.asynctask;

import com.projetoroom.model.Aluno;
import com.projetoroom.model.Telefone;
import com.projetoroom.model.TipoTelefone;
import com.projetoroom.room.dao.AlunoDAO;
import com.projetoroom.room.dao.TelefoneDAO;

import java.util.List;

public class EditaAlunoTask extends BaseAlunoComTelefoneTask {

    private final Aluno aluno;
    private final AlunoDAO alunoDAO;
    private final TelefoneDAO telefoneDAO;
    private final Telefone telefoneFixo;
    private final Telefone telefoneCelular;
    private final List<Telefone> telefonesDoAluno;

    public EditaAlunoTask(Aluno aluno, AlunoDAO alunoDAO, TelefoneDAO telefoneDAO,
                          Telefone telefoneFixo, Telefone telefoneCelular,
                          List<Telefone> telefonesDoAluno, FinalizadaListener listener) {
        super(listener);
        this.aluno = aluno;
        this.alunoDAO = alunoDAO;
        this.telefoneDAO = telefoneDAO;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.telefonesDoAluno = telefonesDoAluno;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        alunoDAO.edita(aluno);
        vinculaAlunoComTelefone(aluno.getId(), telefoneFixo, telefoneCelular);
        atualizaIdsDosTelefones(telefoneFixo, telefoneCelular);
        telefoneDAO.atualiza(telefoneFixo, telefoneCelular);
        return null;
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
}
