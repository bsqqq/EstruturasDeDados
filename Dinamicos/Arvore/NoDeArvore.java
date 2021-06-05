package EstruturasDeDados.Dinamicos.Arvore;

public class NoDeArvore {
    private Object valor;
    private NoDeArvore NoDaDireita;
    private NoDeArvore NoDaEsquerda;

    public NoDeArvore(Object valor) {
        this.NoDaEsquerda = null;
        this.valor = valor;
        this.NoDaDireita = null;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void setNoDaDireita(NoDeArvore NoDaDireita) {
        this.NoDaDireita = NoDaDireita;
    }

    public NoDeArvore getNoDaEsquerda() {
        return NoDaEsquerda;
    }

    public void setNoDaEsquerda(NoDeArvore NoDaEsquerda) {
        this.NoDaEsquerda = NoDaEsquerda;
    }

    public NoDeArvore getNoDaDireita() {
        return NoDaDireita;
    }
}
