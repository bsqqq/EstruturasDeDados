package Estaticos;

public class PilhaEstatica {
    private int[] v;
    private int tamanho;

    public PilhaEstatica(int n) {
        this.v = new int[n];
        this.tamanho = 0;
    }

    public void push(int valor) {
        if(tamanho < v.length) {
//            System.out.println("Pushing... " + valor);
            v[tamanho] = valor;
            tamanho++;
        } else {
            System.out.println("Pilha cheia.");
        }
    }

    public int pop() {
        if(tamanho == 0) {
            System.out.println("Pilha vazia.");
            return -1;
        } else {
//            System.out.println("Popping... " + v[tamanho]);
            tamanho--;
            return v[tamanho];
        }
    }

    public boolean vazio() {
        if (tamanho == 0) {
            return true;
        }
        return false;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void peek() {
        System.out.println("Peeking... " + v[tamanho - 1]);
    }

    // Tenho que melhorar este metodo
//    public void MaiorElemento() {
//        int maior = Integer.MIN_VALUE;
//        for (int i = 0; i < tamanho; i++) {
//            if (v[i] < v[i + 1]) {
//                maior = v[i + 1];
//            } else if (v[i] > v[i + 1]) {
//                maior = v[i];
//            }
//        }
//        System.out.println(maior);
//    }

    public void exibir() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }
}
