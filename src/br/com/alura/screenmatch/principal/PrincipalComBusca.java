package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.excecao.ErrorParaConverterAno;
import br.com.alura.screenmatch.models.Titulo;
import br.com.alura.screenmatch.models.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner letura = new Scanner(System.in);
        System.out.println("Digite um filme para busca: " + "\n");

        try {

            var busca = letura.nextLine().toLowerCase().trim();

            String endereco = "https://www.omdbapi.com/?t=" + URLEncoder.encode(busca, StandardCharsets.UTF_8) + "&apikey=d3bb4a0b";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson json = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            TituloOmdb meuTitulo = json.fromJson(response.body(), TituloOmdb.class);
            System.out.println("Titulo: " + meuTitulo + "\n");


            Titulo newTitulo = new Titulo(meuTitulo);
            System.out.println("Titulo já convertido");
            System.out.println(newTitulo);

        } catch (NumberFormatException error) {

            System.out.println("Aconteceu um erro: " + error.getMessage());

        } catch (IllegalArgumentException error) {
            System.out.println("Algum erro de argumento na busca, verifique o endereco de url");
        }catch (ErrorParaConverterAno e){
            //AQUI PEGAMOS A MENSAGEM DE ERRO DA NOSSA CLASSE
            System.out.println(e.getMensagem());
        }

        System.out.println("O programa finalizou corretamente!");

    }
}
