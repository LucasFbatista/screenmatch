package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.models.Filme;
import br.com.alura.screenmatch.models.Serie;
import br.com.alura.screenmatch.models.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PrincipalComListas {

    public static void main(String[] args) {
        Filme filme = new Filme("O poderoso chefao", 1970);
        Filme outrofilme = new Filme("Avatar 2", 2023);
        Serie serie = new Serie("LOST", 2000);

        filme.setTotalAvaliacoes(10);
        outrofilme.setTotalAvaliacoes(6);
        serie.setTotalAvaliacoes(8);


        //USANDO LIST MANEIRA CORRETA
        List<Titulo> lista = new ArrayList<>();

        lista.add(filme);
        lista.add(outrofilme);
        lista.add(serie);

        for (Titulo item: lista) {
            if(item instanceof  Filme){
                System.out.println("====================================================================================");
                System.out.println("Nome Filme: " + item.getNome() + " Avaliacao: " + item.getTotalAvaliacoes());
            }
        }

        //USANDO ArrayList MANEIRA MAIS ANTIGA MAIS AINDA CORRETA
        ArrayList<String> buscarPorArtista = new ArrayList<>();

        System.out.println("====================================================================================");
        //ORDENACAO
        buscarPorArtista.add("Paulo");
        buscarPorArtista.add("Adam Sandler");
        buscarPorArtista.add("Jacqueline");
        System.out.println(buscarPorArtista);

        Collections.sort(buscarPorArtista);

        System.out.println(buscarPorArtista);

        System.out.println("====================================================================================");
        System.out.println("Lista de titulos ordenados");
        Collections.sort(lista);
        System.out.println(lista);

        System.out.println("====================================================================================");
        System.out.println("Lista de titulos ordenados por ano de lancamento com operador lambda");

        lista.sort(Comparator.comparing(Titulo::getAnoLancamento));

        System.out.println(lista);

    }
}
