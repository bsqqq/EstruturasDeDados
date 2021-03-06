package EstruturasDeDados.Dinamicos.FilaPilha;

public class PilhaEncadeada {
    private No topo;

    public PilhaEncadeada() {
        topo = null;
    }

    public void push(Object n) {
        No novo = new No(n);
        if (estaVazio()) {
            topo = novo;
        } else {
            novo.proximo = topo;
            topo = novo;
        }
    }

    public Object pop() {
        Object valorRemovido = 0;
        if (estaVazio()) {
            System.out.println("está vazio!");
        } else {
            valorRemovido = topo.valor;
            topo = topo.proximo;
        }
        return valorRemovido;
    }

    public Object peek() {
        System.out.println("Peek: " + topo.valor);
        return topo.valor;
    }

    public void exibir() {
        No aux = topo;
        while(aux != null) {
            System.out.print(aux.valor + " ");
            aux = aux.proximo;
        }
        System.out.println();
    }

    public boolean estaVazio() {
        if (topo == null)
            return true;
        return false;
    }
}
