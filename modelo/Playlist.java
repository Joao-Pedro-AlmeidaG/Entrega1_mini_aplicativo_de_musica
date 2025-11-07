package modelo;

import java.util.List;

public class Playlist extends Midia {
    private String nome;
    private String dono;

    public Playlist(String titulo, String artista, double duracao, Genero genero, String nome, String dono, List<Midia> listadeMidias) {
        super(titulo, artista, duracao, genero);
        this.nome = nome;
        this.dono = dono;
        this.listadeMidias = listadeMidias;
    }

    private List<Midia> listadeMidias;

    public void adicionarMidia(Midia midia) {
        this.listadeMidias.add(midia);
    }

    public void removerMidia(Midia midia){
        this.listadeMidias.remove(midia);
    }

    @Override
    public void exibirInfor() {
        System.out.println("");

    }
}
