package EstruturasDeDados.Dinamicos.FilaPilha;

public class No {
    Object valor;
    No proximo;
    int indice;
    public No(Object n) {
        this.valor = n;
        this.proximo = null;
    }
}
