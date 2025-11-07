package modelo;

public abstract class Podcast extends Midia {
    private int numeroDeEpisodio;

    public Podcast(String titulo, String artista, double duracao, Genero genero) {
        super(titulo, artista, duracao, genero);
        this.numeroDeEpisodio=numeroDeEpisodio;
    }

    public int getNumeroDeEpisodio() {
        return numeroDeEpisodio;

    }

    public void setNumeroDeEpisodio(int numeroDeEpisodio) {
        this.numeroDeEpisodio = numeroDeEpisodio;
    }

    @Override
    public String toString() {
        return "Podcast{" +
                "numeroDeEpisodio=" + numeroDeEpisodio +
                '}';
    }
}
