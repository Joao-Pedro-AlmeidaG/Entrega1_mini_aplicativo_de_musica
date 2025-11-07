package modelo;

public abstract class Midia {
    private String titulo;
    private String artista;
    private double duracao;
    private Genero genero;

    public Midia(String titulo, String artista, double duracao, Genero genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;
    }

    public Midia() {

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public abstract void exibirInfor();

    @Override
    public String toString() {
        return "Midia{" +
                "titulo='" + titulo + '\'' +
                ", artista='" + artista + '\'' +
                ", duracao=" + duracao +
                ", genero=" + genero +
                '}';
    }
}

