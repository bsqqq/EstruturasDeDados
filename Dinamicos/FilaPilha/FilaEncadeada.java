package EstruturasDeDados.Dinamicos.FilaPilha;

public class FilaEncadeada {
    private No primeiro;
    private No ultimo;

    public FilaEncadeada() {
        primeiro = null;
        ultimo = null;
    }

    public void enqueue(int n) {
        No novo = new No(n);
        if (estaVazio()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }
    }

    public int dequeue() {
        int valorRemovido = 0;
        if (estaVazio()) {
            System.out.println("está vazio!");
        } else if(primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
        } else if(primeiro != null) {
            No valor = primeiro;
            primeiro = primeiro.proximo;
            return valor.valor;
        }
        return -1;
    }

    public boolean estaVazio() {
        if (primeiro == null) {
            return true;
        }
        return false;
    }

    public int tamanho() {
        int i = 0;
        if (estaVazio()) {
            return 0;
        } else {
            No aux = primeiro;
            while(aux != null) {
                aux = aux.proximo;
                i++;
            }
        }
        return i;
    }

    public void exibir() {
        No aux = primeiro;
        while(aux != null) {
            System.out.print(aux.valor + " ");
            aux = aux.proximo;
        }
        System.out.println();
    }
}
