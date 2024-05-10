package br.com.alura.screenmatch.calculos;

public class FiltroRecomendacao {

    public void filtra(Classificavel classificavel){
        if (classificavel.getClassificao() >= 4){
            System.out.println("Um dos favoritos do momento.");
        } else if (classificavel.getClassificao() >= 2){
            System.out.println("Um dos mais bem avaliados do momento.");
        } else {
            System.out.println("Deixe esse para assistir depois.");
        }
    }
}
