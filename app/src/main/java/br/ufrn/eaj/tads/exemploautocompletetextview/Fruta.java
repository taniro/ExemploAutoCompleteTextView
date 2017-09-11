package br.ufrn.eaj.tads.exemploautocompletetextview;

/**
 * Created by Taniro on 10/09/2017.
 */

public class Fruta {

    String nome;
    String cor;

    public Fruta(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
