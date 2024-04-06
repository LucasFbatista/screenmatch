package br.com.alura.screenmatch.calculo;
import br.com.alura.screenmatch.models.Titulo;

public class CalculadoraDeTempo {
    public int getTempoTotal() {
        return this.tempoTotal;
    }

    private int tempoTotal;

    public void inclui(Titulo titulo){
        this.tempoTotal += titulo.getDuracaoMinutos();
    }

}
