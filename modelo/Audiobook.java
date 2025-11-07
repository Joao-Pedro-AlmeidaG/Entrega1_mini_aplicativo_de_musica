package modelo;

public abstract class Audiobook extends Midia {
    private String narrador;

    public Audiobook(String titulo, String artista, double duracao, Genero genero) {
        super(titulo, artista, duracao, genero);
        this.narrador= narrador;

    }

    public String getNarrador() {
        return narrador;

    }

    public void setNarrador(String narrador) {
        this.narrador = narrador;

    }
}
