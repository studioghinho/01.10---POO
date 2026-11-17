package br.com.starlog.model;

import java.util.HashMap;
import java.util.Map;

/** Gerencia os módulos de carga por meio de seu identificador. */
public class BaseLancamento {
    private Map<String, ModuloCarga> modulos = new HashMap<>();

    public void cadastrarModulo(ModuloCarga modulo) {
        modulos.put(modulo.getIdModulo(), modulo);
    }

    public ModuloCarga buscarModulo(String idModulo) {
        return modulos.get(idModulo);
    }
}
