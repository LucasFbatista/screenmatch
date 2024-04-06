package br.com.alura.screenmatch.models;

import br.com.alura.screenmatch.calculo.Classificavel;

public class Episodio implements Classificavel {
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    private int numero;
    private String nome;
    private String serie;

    public int getTotalVisualizacoes() {
        return totalVisualizacoes;
    }

    public void setTotalVisualizacoes(int totalVisualizacoes) {
        this.totalVisualizacoes = totalVisualizacoes;
    }

    private int totalVisualizacoes;

    @Override
    public int getClassificacao() {
       if(totalVisualizacoes > 100){
            return 4;
       }else{
           return 2;
       }
    }
}
