package br.com.alura.screenmatch.modelos;

public class Serie extends Titulo{

    public Serie(String nome, int anoDeLanamento){
        super( nome, anoDeLanamento);
    }

    private int temporadas;
    private boolean ativa;
    private int epsodiosPorTemporada;
    private int minutosPorTemporada;

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getEpsodiosPorTemporada() {
        return epsodiosPorTemporada;
    }

    public void setEpsodiosPorTemporada(int epsodiosPorTemporada) {
        this.epsodiosPorTemporada = epsodiosPorTemporada;
    }

    public int getMinutosPorTemporada() {
        return minutosPorTemporada;
    }

    public void setMinutosPorTemporada(int minutosPorTemporada) {
        this.minutosPorTemporada = minutosPorTemporada;
    }

    @Override
    public int getDuracaoEmMinutos(){
        return minutosPorTemporada * temporadas * epsodiosPorTemporada;
    }
}
