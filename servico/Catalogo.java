package servico;

import modelo.Midia;

import java.util.HashMap;
import java.util.Map;

public class Catalogo {
    private Map<String, Midia> midias;

    public Catalogo(){
        this.midias = new HashMap<>();
    }

    public void adicionarMidia(Midia midia){
        this.midias.put(midia.getTitulo(), midia);
    }

    public Midia buscarPorTitulo(String titulo) throws MidiaNaoEncontradaException {
        if (midias.containsKey(titulo)) {
            return midias.get(titulo);
        } else {
            throw new MidiaNaoEncontradaException("Mídia com o título " + titulo + " não encontrada.");
        }
    }

    public void removerPorTitulo(String titulo) throws MidiaNaoEncontradaException {
        if (midias.remove(titulo) == null) {
            throw new MidiaNaoEncontradaException("Não foi possível remover: título '" + titulo + "' não encontrado.");
        }
    }

}