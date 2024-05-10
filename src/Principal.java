import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Epsodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme("O poderoso chefão", 1970);

        meuFilme.setIncluidoNoPlano(true);
        meuFilme.setDuracaoEmMinutos(120);
        meuFilme.setDiretor("Paramount");

        meuFilme.exibiFicha();
        meuFilme.avalia(9);
        meuFilme.avalia(5);
        meuFilme.avalia(10);
        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacaoes());
        System.out.println(meuFilme.pegaMedia());

        var filmeDoJuan = new Filme("Velozes e furiosos", 2001);

        filmeDoJuan.setDiretor("Sony");
        filmeDoJuan.setIncluidoNoPlano(true);
        filmeDoJuan.setDuracaoEmMinutos(180);

        Serie minhaSerie = new Serie("Lost", 2001);
        minhaSerie.setAtiva(false);
        minhaSerie.setEpsodiosPorTemporada(22);
        minhaSerie.setTemporadas(10);

        System.out.println("Duração para maratonar a série: " + minhaSerie.getDuracaoEmMinutos() + " minutos");
        minhaSerie.exibiFicha();

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(minhaSerie);
        System.out.println("Duração para maratonar tudo: " + calculadora.getTempoTotal());

        FiltroRecomendacao recomendacao = new FiltroRecomendacao();
        recomendacao.filtra(meuFilme);

        Epsodio epsodio = new Epsodio();
        epsodio.setNumero(1);
        epsodio.setNome("Piloto");
        epsodio.setSerie(minhaSerie);
        epsodio.setTotalDeVizualizacoes(300);

        System.out.println(epsodio.getNome());
        System.out.println(epsodio.getNumero());;
        System.out.println(epsodio.getTotalDeVizualizacoes());

        recomendacao.filtra(epsodio);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(filmeDoJuan);
        System.out.println("Quantidade de filmes: " + listaDeFilmes.size());
        System.out.println("Primeiro filme da lista: " + listaDeFilmes.get(0).getNome());
        System.out.println(listaDeFilmes);
    }
}
