package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Epsodio implements Classificavel {

    private String nome;
    private int numero;
    private Serie serie;
    private int totalDeVizualizacoes;

    public int getTotalDeVizualizacoes() {
        return totalDeVizualizacoes;
    }

    public void setTotalDeVizualizacoes(int totalDeVizualizacoes) {
        this.totalDeVizualizacoes = totalDeVizualizacoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClassificacao() {
       if (totalDeVizualizacoes > 100){
           return 4;
       }
       else {
           return 2;
       }
    }
}
