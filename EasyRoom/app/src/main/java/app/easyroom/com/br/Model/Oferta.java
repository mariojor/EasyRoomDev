package app.easyroom.com.br.Model;

import java.io.Serializable;

/**
 * Created by Saulo on 11/04/2015.
 */
public class Oferta implements Serializable {

    private int Id;
    private String descricao;
    private String titulo;
    private double valaor;
    public Oferta( String descricao, String titulo, double valaor) {
        super();

        this.descricao = descricao;
        this.titulo = titulo;
        this.valaor = valaor;
    }
    public Oferta(int Id, String descricao, String titulo, double valaor) {
        super();
         this.Id = Id;
        this.descricao = descricao;
        this.titulo = titulo;
        this.valaor = valaor;
    }

    public Oferta(){}

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getValaor() {
        return valaor;
    }

    public void setValaor(double valaor) {
        this.valaor = valaor;
    }
}
