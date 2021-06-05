package EstruturasDeDados.Dinamicos.Arvore;
import EstruturasDeDados.Dinamicos.FilaPilha.PilhaEncadeada;

public class Arvore {
    NoDeArvore NoRaiz;

    public Arvore() {
        NoRaiz = null;
    }

    public boolean arvoreVazia() {
        if (NoRaiz == null)
            return true;
        return false;
    }

    public NoDeArvore buscarElemento(Object e) {
        if (arvoreVazia())
            System.out.println("A árvore está vazia!");
        else {
            PilhaEncadeada pilha = new PilhaEncadeada();
            pilha.push(NoRaiz.getValor());
            while(!pilha.estaVazio()) {
                NoDeArvore aux = new NoDeArvore(pilha.pop());
                if (aux.getValor() == e) {
                    return aux;
                }
                if (aux.getNoDaDireita() != null) {
                    pilha.push(aux.getNoDaDireita());
                }
                if (aux.getNoDaEsquerda() != null) {
                    pilha.push(aux.getNoDaEsquerda());
                }
            }
        }
        return null;
    }

    public void adicionarNoEsquerda(Object e, NoDeArvore p) {
        NoDeArvore novo = new NoDeArvore(e);
        if (arvoreVazia())
            NoRaiz = novo;
        else {
            NoDeArvore pai = buscarElemento(p);
            if (pai != null) {
                if (pai.getNoDaEsquerda() == null)
                    pai.setNoDaEsquerda(novo);
                else
                    System.out.println("Este pai já possui um nó a esquerda");
            } else
                System.out.println("Elemento pai não existe");
        }
    }

    public void adicionarNoDireita(Object e, NoDeArvore p) {
        NoDeArvore novo = new NoDeArvore(e);
        if (arvoreVazia())
            NoRaiz = novo;
        else {
            NoDeArvore pai = buscarElemento(p);
            if (pai != null) {
                if (pai.getNoDaDireita() == null)
                    pai.setNoDaDireita(novo);
                else
                    System.out.println("Este pai já possui um nó a esquerda");
            } else
                System.out.println("Elemento pai não existe");
        }
    }

    public Object buscarPai(Object e) {
        if (arvoreVazia())
            return null;
        else {
            PilhaEncadeada pilha = new PilhaEncadeada();
            pilha.push(NoRaiz);
            while (!pilha.estaVazio()) {
                NoDeArvore aux = new NoDeArvore(pilha.pop());
                if (aux.getNoDaDireita().getValor() == e || aux.getNoDaEsquerda().getValor() == e) {
                    return aux;
                }
                if (aux.getNoDaDireita() != null) {
                    pilha.push(aux.getNoDaDireita());
                }
                if (aux.getNoDaEsquerda() != null) {
                    pilha.push(aux.getNoDaEsquerda());
                }
            }
        }
        return null;
    }
}
