package modelo;


import java.util.List;

public class Usuario {
    private String email;
    private String nome;
    private List<Playlist> listaDeMidias;

    public Usuario(String email, String nome, List<Playlist> listaDeMidias) {
        this.email = email;
        this.nome = nome;
        this.listaDeMidias = listaDeMidias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Playlist> getListaDeMidias() {
        return listaDeMidias;
    }

    public void setListaDeMidias(List<Playlist> listaDeMidias) {
        this.listaDeMidias = listaDeMidias;
    }
}
