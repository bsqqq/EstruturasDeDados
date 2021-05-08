package Dinamicos;

public class NoDuplo {
    private Object valor;
    private NoDuplo proximo;
    private NoDuplo anterior;

    public NoDuplo(NoDuplo anterior, Object valor, NoDuplo proximo) {
        this.anterior = anterior;
        this.valor = valor;
        this.proximo = proximo;
    }

    public Object getValor() {
        return valor;
    }

    public void setValor(Object valor) {
        this.valor = valor;
    }

    public void setProximo(NoDuplo proximo) {
        this.proximo = proximo;
    }

    public NoDuplo getAnterior() {
        return anterior;
    }

    public void setAnterior(NoDuplo anterior) {
        this.anterior = anterior;
    }

    public NoDuplo getProximo() {
        return proximo;
    }
}
