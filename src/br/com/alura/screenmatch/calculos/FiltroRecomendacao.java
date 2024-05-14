package br.com.alura.screenmatch.calculos;

public class FiltroRecomendacao {

    public void filtra(Classificavel classificavel){
        if (classificavel.getClassificacao() >= 4){
            System.out.println("Um dos favoritos do momento.");
        } else if (classificavel.getClassificacao() >= 2){
            System.out.println("Um dos mais bem avaliados do momento.");
        } else {
            System.out.println("Deixe esse para assistir depois.");
        }
    }
}
