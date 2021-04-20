package Dinamicos;

public class ListaEncadeada {
    private No primeiro;
    private No ultimo;

    public ListaEncadeada() {
        primeiro = null;
        ultimo = null;
    }

    public void ultimoElemento() {
        if(estaVazio()) {
            System.out.println("Lista está vazia");
        } else {
            System.out.println(ultimo.valor);
        }
    }

    public void penultimoElemento() {
        No aux = primeiro;
        while (aux.proximo != ultimo) {
            aux = aux.proximo;
        }
        System.out.println(aux.valor);
    }

    public int retornarElementoN(int pos) {
        No aux = primeiro;
        for (int i = 0; i < pos; i++) {
            aux = aux.proximo;
        }
        System.out.println(aux.valor);
        return aux.valor;
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
            return i;
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


    public void adicionarFinal(int n) {
        No novo = new No(n);
        if (estaVazio()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            ultimo.proximo = novo;
            ultimo = novo;
        }
    }

    public void adicionarInicio(int n) {
        No novo =  new No(n);
        if (estaVazio()) {
            primeiro = novo;
            ultimo = novo;
        } else {
            novo.proximo = primeiro;
            primeiro = novo;
        }
    }

    public int removerInicio() {
        int valorRemovido = 0;
        if (estaVazio()) {
            System.out.println("está vazio!");
        } else {
            if (primeiro == ultimo) {
                primeiro = null;
                ultimo = null;
            } else {
                valorRemovido = primeiro.valor;
                primeiro = primeiro.proximo;
            }
        }
        return valorRemovido;
    }

    public int removerFinal() {
        int valorRemovido = 0;
        if (ultimo != null) {
            if (primeiro == ultimo) {
                primeiro = null;
                ultimo = null;
            } else {
                No atual = primeiro;
                valorRemovido = ultimo.valor;
                while(atual.proximo != ultimo) {
                    atual = atual.proximo;
                }
                ultimo = atual;
                ultimo.proximo = null;
            }
        }
        return valorRemovido;
    }

    public void removerPosicaoN(int pos) {
        No aux = primeiro;
        if (estaVazio()) {
            System.out.println("Lista está vazia");
        } else {
            for (int i = pos; i >= 0; i--) {
                aux = aux.proximo;
            }
        }
    }

    public boolean temRepetido() {
        boolean flag = false;
        if (estaVazio()) {
            System.out.println("Lista está vazia");
        } else {
            No aux = primeiro;
            int[] numeros = new int[tamanho()];
            int i = 0;
            while(aux != null) {
                numeros[i] = aux.valor;
                aux = aux.proximo;
                i++;
            }
            for(int k = 0; k <= tamanho() - 1; k++) {
                for (int j = 0; j <= tamanho() - 1; j++) {
//                    System.out.printf("numeros[%d] = %d, numeros[%d] = %d \n", k, numeros[k], j, numeros[j]);
                    if (numeros[k] == numeros[j] && k != j) {
                        flag = true;
                    }
                }
            }
        }
        System.out.println(flag);
        return flag;
    }
}
