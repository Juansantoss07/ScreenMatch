package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        var busca = "";
        List<Titulo> filmes = new ArrayList<>();


        while(!busca.equalsIgnoreCase("Sair")) {
            System.out.println("Digite o nome de um filme para ver suas informações:");
            busca = scanner.nextLine();

            if(busca.equalsIgnoreCase("Sair")){
                break;
            }

            try {
                var endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=7b19864c";
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println(json);

                Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

                TituloOmdb tituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(tituloOmdb);

                if (tituloOmdb.year().length() > 4) {
                    throw new ErroDeConversaoDeAnoException("" +
                            "Não foi possível localizar o ano, pois o valor informado possui mais de 4 cara  cteres."
                    );
                }

                Titulo meuTitulo = new Titulo(tituloOmdb);
                System.out.println(meuTitulo);

                filmes.add(meuTitulo);
                System.out.println(filmes);

            } catch (NumberFormatException e) {
                System.out.println("Opa... Teve um erro aqui: " + e.getMessage());
            } catch (ErroDeConversaoDeAnoException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Finalizado!");
        Gson filmesJson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        FileWriter escrita = new FileWriter("filmes.json");
        escrita.write(filmesJson.toJson(filmes));
        escrita.close();
    }
}
