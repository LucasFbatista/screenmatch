package br.com.alura.screenmatch.models;

import br.com.alura.screenmatch.excecao.ErrorParaConverterAno;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable<Titulo>{

    public Titulo(String nome, int anoLancamento) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
    }

    public Titulo(TituloOmdb meuTitulo) {
        this.nome = meuTitulo.title();

        if(meuTitulo.year().length() > 4){
            throw new ErrorParaConverterAno("Nao consegui converter ano possui mais de 4 caracteres");
        }

        this.anoLancamento = Integer.parseInt(meuTitulo.year());
        this.duracaoMinutos = Integer.parseInt(meuTitulo.runtime().substring(0,2));
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public int getTotalAvaliacoes() {
        return totalAvaliacoes;
    }

    public void setTotalAvaliacoes(int totalAvaliacoes) {
        this.totalAvaliacoes = totalAvaliacoes;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    private String nome;
    private int anoLancamento;
    private boolean incluidoNoPlano;
    private double somaAvaliacoes;
    private int totalAvaliacoes;
    private int duracaoMinutos;

    public void exibeFichaTecnica(){
        System.out.println("Nome do filme: " + nome);
        System.out.println("Ano de lancamento: " + anoLancamento);
    }

    public void avalia(double nota){
        somaAvaliacoes += nota;
        totalAvaliacoes++;
    }

    public double obterMediaAvaliacao(){
        return somaAvaliacoes / totalAvaliacoes;
    }

    public double getSomaAvaliacoes() {
        return somaAvaliacoes;
    }

    public void setSomaAvaliacoes(double somaAvaliacoes) {
        this.somaAvaliacoes = somaAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.nome);
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", anoLancamento=" + anoLancamento +
                ", duracaoMinutos=" + duracaoMinutos;
    }
}
