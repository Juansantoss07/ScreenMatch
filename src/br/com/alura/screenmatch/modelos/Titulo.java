package br.com.alura.screenmatch.modelos;

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
        String titulos = "Título: " + this.getNome() + " (" + this.getDataLancamento() + ")";
        return titulos;
    }

    @Override
    public int compareTo(Titulo o) {
        return this.getNome().compareTo(o.getNome());
    }
}
