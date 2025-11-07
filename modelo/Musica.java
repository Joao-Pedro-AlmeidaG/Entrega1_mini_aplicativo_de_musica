package modelo;

public abstract class Musica extends Midia {



    public Musica() {
        super();
    }

    @Override
    public String toString() {
        return "Musica{}";
    }

    public Musica(String titulo, String artista, double duracao, Genero genero) {
        super(titulo, artista, duracao, genero);


    }
}
