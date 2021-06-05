package EstruturasDeDados.Dinamicos.Listas;

public class ListaDuplamenteEncadeadaCircular {
    private NoDuplo inicio;
    private NoDuplo fim;
    private int tamanho;

    public ListaDuplamenteEncadeadaCircular() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public boolean estaVazio() {
        if (inicio == null)
            return true;
        return false;
    }

    public int tamanho() {
        if (estaVazio()) {
            return 0;
        }
        int i = 0;
        NoDuplo aux = inicio;
        while(aux.getProximo() != fim) {
            i++;
            aux = aux.getProximo();
        }
        return i;
    }

    public void exibir() {
        if (estaVazio()) {
            System.out.println("Está vazio");
            return;
        }
        NoDuplo aux = inicio;
        int i = 0;
        try {
            while(i < tamanho) {
                System.out.print(aux.getValor() + " ");
                aux = aux.getProximo();
                i++;
            }
            System.out.println();
        }
            catch (NullPointerException e) {
                System.out.println("aqui tem um nulo");
            }
    }

    public void exibirReverse() {
        if (estaVazio()) {
            System.out.println("Está vazio");
            return;
        }
        NoDuplo aux = fim;
        int i = 0;
        try {
            while(i < tamanho) {
                System.out.print(aux.getValor() + " ");
                aux = aux.getAnterior();
                i++;
            }
            System.out.println();
        }
        catch (NullPointerException e) {
            System.out.println("aqui tem um nulo");
        }
    }

    public void adicionarInicio(Object valor) {
        NoDuplo novo = new NoDuplo(fim, valor, inicio);
        if (!estaVazio())
            inicio = novo;
        else {
            fim = novo;
            inicio = novo;
        }
        tamanho++;
        return;
    }

    public void adicionarFim(Object valor) {
        NoDuplo novo = new NoDuplo(fim, valor, inicio);
        if (estaVazio()){
            fim = novo;
            inicio = novo;
        } else {
            fim = novo;
        }
        tamanho++;
        return;
    }

    public Object removerInicio() {
        if (!estaVazio()) {
            Object retorno = inicio;
            inicio = inicio.getProximo();
            tamanho--;
            return retorno;
        } else
            return null;
    }

    public Object removerFim() {
        if (!estaVazio()) {
            Object retorno = fim;
            fim = fim.getAnterior();
            fim.setProximo(inicio);
            tamanho--;
            return retorno;
        } else
            return null;
    }

    public Object buscar(Object item) {
        Object itembuscado = null;
        int i = 0;
            NoDuplo aux = inicio;
            try {
                while(aux.getValor() != item) {
                    aux = aux.getProximo();
                    i++;
                }
            } catch (NullPointerException e) {
                System.out.println("Não foi possivel localizar o pedido, talvez seu pedido não exista na lista");
            }
            finally {
                itembuscado = aux.getValor();
                if (itembuscado == item)
                    System.out.println(itembuscado.toString() + ", indice: " + i);
                else
                    System.out.println(-1);
                return itembuscado;
            }
    }

    public Object[] qualSeRepeteMais() {
        NoDuplo aux = inicio;
        Object[] valores = new Object[tamanho];
        Object[] resultado = new Object[tamanho];
        int qntd = 0;
        int a = 0;
        while(a < tamanho) {
            valores[a] = aux.getValor();
            aux = aux.getProximo();
            a++;
        }
        for (int i = 0; i < tamanho; i++) {
            for(int k = 0; k < tamanho; k++) {
                if (valores[i] == valores[k] && k != i) {
                    resultado[i] = valores[i];
                    resultado[i + 1] = qntd++;
                }
            }
        }
        System.out.println("O elemento que mais se repete é " + resultado[0] +"'");
        return resultado;
    }
}
