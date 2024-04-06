package br.com.alura.screenmatch.models;

import br.com.alura.screenmatch.calculo.Classificavel;

public class Filme extends Titulo implements Classificavel {

    public  Filme(String nomeFilme, int anoLancamento){
        super(nomeFilme, anoLancamento);
    }
    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    private String diretor;

    @Override
    public int getClassificacao() {
        return (int) obterMediaAvaliacao() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getAnoLancamento() + ")";
    }
}
