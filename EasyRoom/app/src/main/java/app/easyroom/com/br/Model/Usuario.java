package app.easyroom.com.br.Model;

import java.io.Serializable;

/**
 * Created by Saulo on 22/03/2015.
 */
public class Usuario implements Serializable{

    private int Id;
    private String senha;
    private String email;

    public Usuario(String email) {
        super();
        this.email = email;
    }

    public Usuario(String email, String senha) {
        super();
        this.email = email;
        this.senha = senha;
    }


    public Usuario(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
