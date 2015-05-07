package app.easyroom.com.br.Model;

import java.io.Serializable;

/**
 * Created by Saulo on 11/04/2015.
 */
public class Anuncio implements Serializable {

    private int Id;
    private int IdOferta;
    private int IdUsuario;

    public Anuncio(int id, int idOferta, int idUsuario) {
        super();
        Id = id;
        IdOferta = idOferta;
        IdUsuario = idUsuario;
    }

    public Anuncio(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getIdOferta() {
        return IdOferta;
    }

    public void setIdOferta(int idOferta) {
        IdOferta = idOferta;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        IdUsuario = idUsuario;
    }

}
