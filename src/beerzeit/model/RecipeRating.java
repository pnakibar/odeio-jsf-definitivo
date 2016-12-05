package beerzeit.model;

import java.io.Serializable;

/**
 * Created by pedro on 29/11/16.
 */
public class RecipeRating implements Serializable{
    private static final long serialVersionUID = 8940655301905748006L;
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
