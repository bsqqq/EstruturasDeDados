package Estaticos;

public class FilaEstatica {
    private int[] fila;
    private int tamanho;
    private int valorDoMaiorSalario;
    private String nomeDoMaiorSalario;

    public FilaEstatica(int n) {
        this.fila = new int[n];
        this.tamanho = 0;
        this.valorDoMaiorSalario = 0;
    }

    public void enqueue(int valor) {
        if (tamanho < fila.length) {
            fila[tamanho] = valor;
            tamanho++;
        } else
            System.out.println("Fila cheia");
    }

    public void dequeue() {
        if (tamanho == 0) {
            System.out.println("Fila vazia");
        } else {
            for (int i = 0; i < tamanho ; i++) {
                fila[i] = fila[i+1];
            }
            tamanho--;
        }
    }

    public int getTamanho() {
        return tamanho;
    }

    public boolean vazio() {
        if (tamanho == 0) {
            return true;
        }
        return false;
    }

    public void exibir(){
        for (int i = 0; i < tamanho; i++) {
            System.out.print(fila[i] + " ");
        }
        System.out.println();
    }

}
