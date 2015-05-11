package app.easyroom.com.br.Model;

import java.io.Serializable;

/**
 * Created by Saulo on 11/04/2015.
 */
public class Oferta implements Serializable {

    private int Id;
    private String descricao;
    private String titulo;
    private String telefone;
    private String endereco;
    private double valor;


    public Oferta(String descricao, String titulo,String telefone,String endereco, double valor) {
        super();
        this.descricao = descricao;
        this.titulo = titulo;
        this.telefone = telefone;
        this.endereco = endereco;
        this.valor = valor;
    }
    public Oferta(int Id, String descricao, String titulo,String telefone, String endereco, double valor) {
        super();
        this.Id = Id;
        this.descricao = descricao;
        this.titulo = titulo;
        this.telefone = telefone;
        this.endereco = endereco;
        this.valor = valor;
    }

    public Oferta(){}

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
}
