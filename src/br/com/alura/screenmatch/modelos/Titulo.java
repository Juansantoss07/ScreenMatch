package br.com.alura.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

import java.io.Serial;

public class Titulo implements Comparable<Titulo> {

    private String nome;
    private int dataLancamento;
    private boolean incluidoNoPlano;
    private double somarAvaliacoes;
    private int totalDeAvaliacaoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int dataLancamento){
        this.setNome(nome);
        this.setDataLancamento(dataLancamento);
    }

    public Titulo(TituloOmdb tituloOmdb) {
        this.nome = tituloOmdb.title();
        this.dataLancamento = Integer.parseInt(tituloOmdb.year());
        this.duracaoEmMinutos = Integer.parseInt(tituloOmdb.runtime().substring(0,3));
    }

    public double getSomarAvaliacoes(){
        return somarAvaliacoes;
    }

    public int getDataLancamento() {
        return dataLancamento;
    }

    public String getNome() {
        return nome;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setDataLancamento(int dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getDuracaoEmMinutos(){
        return duracaoEmMinutos;
    }

    public void exibiFicha() {
        System.out.println("Nome do filme: " + nome);
        System.out.println("Data de lançamento do filme: " + dataLancamento);
    }

    public int getTotalDeAvaliacaoes(){
        return totalDeAvaliacaoes;
    }

    public void avalia(double nota) {
        somarAvaliacoes += nota;
        totalDeAvaliacaoes++;
    }

    public double pegaMedia() {
        return somarAvaliacoes / totalDeAvaliacaoes;
    }

    @Override
    public String toString(){
        String titulos = "Título: " +
                this.getNome() + " (" +
                this.getDataLancamento() + ") " +
                "Tempo de filme: " +
                this.getDuracaoEmMinutos() + " min";
        return titulos;
    }

    @Override
    public int compareTo(Titulo o) {
        return this.getNome().compareTo(o.getNome());
    }
}
