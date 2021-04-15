package Estaticos;

public class ListaEstatica {
    private int[] v;
    private int tamanho;

    public ListaEstatica(int n) {
        this.v = new int[n];
        this.tamanho = 0;
    }

    public void adicionarFinal(int valor) {
        if (tamanho < v.length) {
            v[tamanho] = valor;
            tamanho++;
        } else
            System.out.println("Lista cheia");
    }

    public void adicionarPos(int valor, int pos) {
        if (pos < v.length) {
            for(int i = tamanho; i > pos; i--)
                v[i] = v[i-1];
            v[pos] = valor;
            tamanho++;
        } else
            System.out.println("Posição informada não existe");
    }

    public void adicionarInicio(int valor) {
        adicionarPos(valor, 0);
    }

    public void removerFinal() {
        if (tamanho == 0) {
            System.out.println("Lista vazia");
        } else
            tamanho--;
    }

    public void removerPos(int pos) {
        if (tamanho == 0)
            System.out.println("Lista vazia");
        else {
            for (int i = pos; i < tamanho - 1; i++) {
                v[i] = v[i+1];
            }
            tamanho--;
        }
    }

    public void removerInicio() {
        removerPos(0);
    }

    public int buscar(int valor) {
        for (int i = 0; i < tamanho; i++)   {
            if (valor == v[i])
                return i;
        }
        return -1;
    }

    public void buscarDoMeio() {
        if (tamanho % 2 == 0 || tamanho <= 2) {
            System.out.println("A lista não tem um meio");
        } else {
            System.out.println("Meio: " + v[tamanho / 2]);
        }
    }

    public void trocar() {
        int aux;
        aux = v[0];
        v[0] = v[tamanho - 1];
        v[tamanho - 1] = aux;
    }

    public void inverterLista() {
        int aux;
        for(int i = 0; i < Math.floorDiv(tamanho, 2); i++) {
            aux = v[i];
            v[i] = v[tamanho - i - 1];
            v[tamanho - i - 1] = aux;
        }

    }
    public void eliminarRepetidos() {
        if (getTamanho() == 0) {
            System.out.println("Lista está vazia");
        } else {
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    if (v[j] == v[i] && i != j) {
                        removerPos(j);
                    }
                }
            }
        }
    }

    public boolean vazio() {
        if (tamanho == 0)
            return true;
        return false;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void exibir(){
        for (int i = 0; i < tamanho; i++) {
            System.out.print(v[i] + " ");
        }
        System.out.println();
    }
}
