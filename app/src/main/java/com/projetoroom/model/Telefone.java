package com.projetoroom.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity
//@Entity(foreignKeys = @ForeignKey(entity = Aluno.class, parentColumns = "id", childColumns = "alunoId"))
// assim n preciçando do onUpdate e onDelete.
public class Telefone {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String numero;

    // @ColumnInfo(name = "aluno_id") modifcador de nome, indicando como vai ser gravado no banco de dados
    @ForeignKey(entity = Aluno.class,
            parentColumns = "id",
            childColumns = "alunoId",
            onUpdate = CASCADE,
            onDelete = CASCADE)
    private int alunoId;
    private TipoTelefone tipo;

    public Telefone(String numero, TipoTelefone tipo) {
        this.numero = numero;
        this.tipo = tipo;
    }

    public int getAlunoId() {
        return alunoId;
    }

    public void setAlunoId(int alunoId) {
        this.alunoId = alunoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public TipoTelefone getTipo() {
        return tipo;
    }
}