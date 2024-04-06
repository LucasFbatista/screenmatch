package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.calculo.CalculadoraDeTempo;
import br.com.alura.screenmatch.calculo.FiltroRecomendacao;
import br.com.alura.screenmatch.models.Filme;
import br.com.alura.screenmatch.models.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Filme filme = new Filme("O poderoso chefao", 1970);

        //filme.setNome("O poderoso chefao");
        //filme.setAnoLancamento(1970);
        filme.setDuracaoMinutos(180);
        System.out.println("Duracao do filme: " + filme.getDuracaoMinutos());


        filme.exibeFichaTecnica();
        filme.avalia(8);
        filme.avalia(5);
        filme.avalia(10);

        System.out.println("Total avaliacoes: " + filme.getSomaAvaliacoes());
        System.out.println(filme.getTotalAvaliacoes());
        System.out.println(filme.obterMediaAvaliacao());

        Serie serie = new Serie("LOST", 2000);
        //serie.setNome("LOST");
        //serie.setAnoLancamento(2000);
        serie.exibeFichaTecnica();
        serie.setTemporadas(10);
        serie.setEpisodiosPorTemporada(10);
        serie.setMinutosPorEpisodio(50);
        System.out.println("Duracao da serie: " + serie.getDuracaoMinutos() + " Minutos");

        Filme outrofilme = new Filme("Avatar 2", 2023);

        //outrofilme.setNome("Avatar 2");
        //outrofilme.setAnoLancamento(2023);
        outrofilme.setDuracaoMinutos(200);
        System.out.println("Duracao do filme: " + outrofilme.getDuracaoMinutos());


        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(filme);
        calculadora.inclui(serie);
        calculadora.inclui(outrofilme);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();

        System.out.println("==========================================================");
        filtro.filtraRecomendado(filme);
        filtro.filtraRecomendado(outrofilme);
        System.out.println("==========================================================");

        ArrayList<Filme> listFilmes = new ArrayList<>();

        listFilmes.add(filme);
        listFilmes.add(outrofilme);

        System.out.println("Tamanho da lista: " + listFilmes.size());
        System.out.println(listFilmes.get(0).toString());
    }
}
