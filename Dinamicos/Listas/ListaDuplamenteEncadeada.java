package EstruturasDeDados.Dinamicos.Listas;

public class ListaDuplamenteEncadeada {
    private NoDuplo inicio;
    private NoDuplo fim;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
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
                if (i % 4 == 0) {
                    System.out.println();
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println("aqui tem um nulo");
        }
        finally {
            System.out.println();
        }
    }

    public void exibirAoContrario() {
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
        }
        catch (NullPointerException e) {
            System.out.println("aqui tem um nulo");
        }
        finally {
            System.out.println();
        }
    }

    public void adicionarInicio(Object valor) {
        NoDuplo novo = new NoDuplo(null, valor, inicio);
        if (!estaVazio())
            inicio.setAnterior(novo);
        else
            fim = novo;
        inicio = novo;
        tamanho++;
    }

    public void adicionarFim(Object valor) {
        NoDuplo novo = new NoDuplo(fim, valor, null);
        if (estaVazio())
            inicio = novo;
        else
            fim.setProximo(novo);
        fim = novo;
        tamanho++;
    }

    public void adicionarPosicaoN(int pos, int valor) {
        if(pos < 0 || pos > tamanho) {
            System.out.println("Posição Invalida");
        } else if (pos == 0) {
            adicionarInicio(valor);
        } else {
            NoDuplo aux = inicio;
            for(int i = 0; i < pos - 1; i++) {
                aux = aux.getProximo();
            }
            NoDuplo novo = new NoDuplo(aux, valor, aux.getProximo());
            aux.getProximo().setAnterior(novo);
            aux.setProximo(novo);
            tamanho++;
        }
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

    public Object buscarPeloItem(Object item) {
        Object itembuscado;
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

    public Object buscarPeloIndice(int indice) {
        Object itembuscado;
        int i = 0;
        NoDuplo aux = inicio;
        try {
            while(i != indice) {
                aux = aux.getProximo();
                i++;
            }
        } catch (NullPointerException e) {
            System.out.println("Não foi possivel localizar o pedido, talvez seu pedido não exista na lista");
        }
        finally {
            itembuscado = aux.getValor();
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
        System.out.println("O elemento que mais se repete é " + resultado[0] + "'");
        return resultado;
    }
}
