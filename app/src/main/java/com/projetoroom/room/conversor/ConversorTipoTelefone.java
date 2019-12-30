package com.projetoroom.room.conversor;

import androidx.room.TypeConverter;

import com.projetoroom.model.TipoTelefone;

public class ConversorTipoTelefone {

    @TypeConverter
    public String toString(TipoTelefone tipo) {
        return tipo.name();
    }

    @TypeConverter
    public TipoTelefone toTipoTelefone(String valor) {
        if (valor != null) {
            TipoTelefone.valueOf(valor);
        }
        return TipoTelefone.FIXO;
    }
}