package Dinamicos;

public class ListaCircular {
    private No primeiro;
    private No ultimo;
    int tamanho;
    
    public ListaCircular() {
        this.primeiro = null;
        this.ultimo = null;
    }

    public boolean estaVazio() {
        if(primeiro == null) {
            return true;
        }
        return false;
    }
    public void exibir() {
        if (estaVazio()) {
            System.out.println("Nada a mostrar...");
        } else {
            No aux = primeiro;
            while(aux != null) {
                System.out.print(aux.valor + " ");
                aux = aux.proximo;
            }
            System.out.println();
        }
    }

    public int tamanho() {
        int i = 0;
        No aux = primeiro;
        if (estaVazio()) {
            System.out.println("Está vazia");
            return i;
        } else {
            while(aux != null) {
                i++;
                aux = aux.proximo;
            }
        }
        return i;
    }

    public void adicionarInicio(int valor) {
        No novo = new No(valor);
        if (estaVazio()) {
            primeiro = novo;
            ultimo = novo;
            ultimo.proximo = primeiro;
        } else {
            novo.proximo = primeiro;
            primeiro = novo;
        }
    }

    public void adicionarFinal(int valor) {
        No novo = new No(valor);
        if (estaVazio()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
            ultimo.proximo = primeiro;
        }
    }

    public int removerInicio() {
        int valorRemovido = 0;
        if (estaVazio()) {
            System.out.println("Está vazia!");
        } else if(primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
        } else {
            valorRemovido = primeiro.valor;
            primeiro = primeiro.proximo;
        }
        return valorRemovido;
    }

    public int removerFinal() {
        int valorRemovido = 0;
        if (estaVazio()) {
            System.out.println("Está vazio");
        } else if(primeiro == ultimo) {
            primeiro = null;
            ultimo = null;
        } else {
            No atual = primeiro;
            valorRemovido = ultimo.valor;
            while(atual.proximo != ultimo) {
                atual = atual.proximo;
            }
            ultimo = atual;
            ultimo.proximo = primeiro;
        }
        return valorRemovido;
    }
}
