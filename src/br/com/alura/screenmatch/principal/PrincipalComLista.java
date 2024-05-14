package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalComLista {
    public static void main(String[] args) {
        Filme avatar = new Filme("Avatar", 2018);
        Filme gigantesDeAco = new Filme("Gigantes de aço", 2011);
        Serie strangerThings = new Serie("Stranger Things", 2016);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(avatar);
        lista.add(gigantesDeAco);
        lista.add(strangerThings);

        for(Titulo item: lista){
            System.out.println(item);
            if (item instanceof Filme filme){
                System.out.println("Classificação: "  + filme.getClassificacao());
            }
        }

        List<String> buscaPorArtistas = new LinkedList<>();
        buscaPorArtistas.add("Adam Sandler");
        buscaPorArtistas.add("Jack Shan");
        buscaPorArtistas.add("Bruce wayne");

        System.out.println(buscaPorArtistas);

        Collections.sort(buscaPorArtistas);
        System.out.println("Ordenado:");
        System.out.println(buscaPorArtistas);

        Collections.sort(lista);
        System.out.println("Lista ordenada:");
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getDataLancamento));
        System.out.println("Lista ordenada por ano de lançamento:");
        System.out.println(lista);
    }
}
