package br.pucbr.exemplo.util.excecao;

public class ExcecaoExemplo extends Exception {

    public ExcecaoExemplo(String codigo, String mensagem) {
        super(mensagem);
        this.codigo = codigo;
        this.mensagem = mensagem;
    }

    private String mensagem;
    private String codigo;

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
