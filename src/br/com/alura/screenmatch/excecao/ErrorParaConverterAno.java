package br.com.alura.screenmatch.excecao;

public class ErrorParaConverterAno extends RuntimeException {
    private String mensagem;
    public ErrorParaConverterAno(String m) {
        this.mensagem = m;
    }

    public String getMensagem() {
        return this.mensagem;
    }
}
