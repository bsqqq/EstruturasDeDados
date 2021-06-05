package EstruturasDeDados.Dinamicos.Listas;

public class ListaCircular {
    private No primeiro;
    private No ultimo;

    public ListaCircular() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public boolean estaVazio() {
        if(primeiro == null)
            return true;
        return false;
    }

    public void exibir() {
        No aux = primeiro;
        while(aux != ultimo) {
            System.out.print(aux.valor + " ");
            aux = aux.proximo;
        }
        System.out.println();
    }

    public int tamanho() {
        int i = 0;
        if (estaVazio()) {
            System.out.println("Está vazia");
            return i;
        } else {
            No aux = primeiro;
            while(aux != null) {
                i++;
                aux = aux.proximo;
            }
        }
        return i;
    }

    public void adicionarInicio(int valor) {
        No novo = new No(valor);
        if(estaVazio()) {
            primeiro = novo;
            ultimo = novo;
            return;
        }
        novo.proximo = primeiro;
        primeiro = novo;
        return;
    }

    public void inserir(int pos, int valor) {
        No novo = new No(valor);
        if (pos > tamanho()) {
            System.out.println("Posição informada é maior que o tamanho da lista!");
            System.out.println("Selecione outra posição menor que " + tamanho());
        } else if (pos > 0 && pos < tamanho()) {
            No aux = primeiro;
            int count = 1;
            while(count < pos) {
                aux = aux.proximo;
                count++;
            }
            No aux2 = aux.proximo;
            aux.proximo = novo;
            novo.proximo = aux2;
        }
    }

    public void adicionarFinal(int valor) {
        No novo = new No(valor);
        if(estaVazio()) {
            primeiro = novo;
            ultimo = novo;
            return;
        }
        No aux = primeiro;
        while(aux != ultimo) {
            aux = aux.proximo;
        }
        aux.proximo = novo;
        novo.proximo = primeiro;
        return;
    }

    public No removerInicio() {
        if(estaVazio()) {
            System.out.println("Está vazia!");
            return null;
        }
        No NoRemovido = primeiro;
        primeiro = primeiro.proximo;
        NoRemovido.proximo = null;
        return NoRemovido;
    }

    public No removerFinal() {
        if (estaVazio()) {
            System.out.println("Está vazio");
        }
        if(primeiro.proximo == null) {
            No aux = primeiro;
            primeiro = primeiro.proximo;
            aux.proximo = null;
            return aux;
        }
        No aux = primeiro;
        No temp = null;
        while(aux.proximo != null) {
            temp = aux;
            aux = aux.proximo;
        }
        temp.proximo = primeiro;
        return temp;
    }
}
