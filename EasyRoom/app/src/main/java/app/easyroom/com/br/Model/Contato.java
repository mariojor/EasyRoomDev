package app.easyroom.com.br.Model;

import java.io.Serializable;

/**
 * Created by Saulo on 22/03/2015.
 */
public class Contato  implements Serializable {
    private int Id;
    private Usuario usuario;
    private String email;
    private String fone;

    public Contato(int id, Usuario usuario, String email, String fone) {
        super();
        Id = id;
        this.usuario = usuario;
        this.email = email;
        this.fone = fone;
    }
    public Contato( Usuario usuario, String email, String fone) {
        super();
        this.usuario = usuario;
        this.email = email;
        this.fone = fone;
    }
    public Contato(){}
    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public int  getIdUsuario() {

        return usuario.getId();
    }
    public void setIdUsuario(Usuario idUsuario) {
        this.usuario.setId(idUsuario.getId());

    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getFone() {
        return fone;
    }
    public void setFone(String fone) {
        this.fone = fone;
    }



}
