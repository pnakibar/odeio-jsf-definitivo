package beerzeit.model;

/**
 * Created by pedro on 29/11/16.
 */
public class RecipeRating {
    protected Usuario usuario;
    protected int nota;

    public RecipeRating(Usuario usuario, int nota) {
        this.usuario = usuario;
        this.nota = nota;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
