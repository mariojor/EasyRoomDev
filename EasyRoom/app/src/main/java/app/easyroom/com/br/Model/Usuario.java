package app.easyroom.com.br.Model;

import java.io.Serializable;

/**
 * Created by Saulo on 22/03/2015.
 */
public class Usuario implements Serializable{

    private int Id;
    private String login;
    private int senha;
    private String email;
    private String fone;


    public Usuario(int id, String login, int senha) {
        super();

        Id = id;
        this.login = login;
        this.senha = senha;
    }
    public Usuario(String login, int senha,String email,String fone) {
        super();

        this.login = login;
        this.senha = senha;
        this.email = email;
        this.fone = fone;
    }
    public Usuario(){}


    public int getId() {
        return Id;
    }


    public void setId(int id) {
        Id = id;
    }


    public String getLogin() {
        return login;
    }


    public void setLogin(String login) {
        this.login = login;
    }


    public int getSenha() {
        return senha;
    }


    public void setSenha(int senha) {
        this.senha = senha;
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