public class ArvoreBinaria {
    private Node raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public boolean vazia() {
        return this.raiz == null;
    }


    public void insere(int info) {
        this.raiz = inserir(this.raiz, info);
    }

    private Node inserir(Node no, int info) {
        if (no == null)
            return new Node(info);

        if (info < no.getInfo())
            no.setNoEsquerdo(inserir(no.getNoEsquerdo(), info));
        else if (info > no.getInfo())
            no.setNoDireito(inserir(no.getNoDireito(), info));
        else
            return no;


        int balanceamento = fatorBalanceamento(no);

        if (balanceamento > 1 && info < no.getNoEsquerdo().getInfo())
            return rotacaoDireita(no);

        if (balanceamento < -1 && info > no.getNoDireito().getInfo())
            return rotacaoEsquerda(no);

        if (balanceamento > 1 && info > no.getNoEsquerdo().getInfo()) {
            no.setNoEsquerdo(rotacaoEsquerda(no.getNoEsquerdo()));
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && info < no.getNoDireito().getInfo()) {
            no.setNoDireito(rotacaoDireita(no.getNoDireito()));
            return rotacaoEsquerda(no);
        }
        return no;
    }


    public void preOrdem(Node no){
        if (no == null) {
            no = raiz;
        }
        if (no != null) {
            System.out.println(no.getInfo());
            if (no.getNoEsquerdo() != null) {
                preOrdem(no.getNoEsquerdo());
            }
            if (no.getNoDireito() != null) {
                preOrdem(no.getNoDireito());
            }
        }
    }

    public void inOrdem(Node no) {
        if (no == null) {
            no = raiz;
        }
        if (no != null) {
            if (no.getNoEsquerdo() != null) {
                inOrdem(no.getNoEsquerdo());
            }
            System.out.println(no.getInfo());
            if (no.getNoDireito() != null) {
                inOrdem(no.getNoDireito());
            }
        }
    }

    public void posOrdem(Node no) {
        if (no == null) {
            no = raiz;
        }
        if (no != null) {
            if (no.getNoEsquerdo() != null) {
                posOrdem(no.getNoEsquerdo());
            }
            if (no.getNoDireito() != null) {
                posOrdem(no.getNoDireito());
            }
            System.out.println(no.getInfo());
        }

    }

    public boolean noFolha(Node no) {
        if (no.getNoDireito() == null && no.getNoEsquerdo() == null) {
            return true;
        }
        if (no.getNoDireito() != null || no.getNoEsquerdo() != null) {
            return false;
        }
        else {
            if (no.getInfo() > raiz.getInfo()) {
                no = no.getNoDireito();
                raiz = no;
                noFolha(no);
            }
            else if (no.getInfo() < raiz.getInfo()) {
                no = no.getNoEsquerdo();
                raiz = no;
                noFolha(no);
            }
        }
        return false;
    }

    public Node buscar(int elemento) {
        Node ponteiro = raiz;
        while (ponteiro != null && ponteiro.getInfo() != elemento) {
            if (elemento > ponteiro.getInfo()) {
                ponteiro = ponteiro.getNoDireito();
            }
            else {
                ponteiro = ponteiro.getNoEsquerdo();
            }
        }
        return ponteiro;
    }


    private Node buscarMenor(Node no) {
        if (no == null) {
            no = raiz;
        }
        Node atual = no;
        while (atual.getNoEsquerdo() != null) {
            atual = atual.getNoEsquerdo();
        }
        return atual;
    }


    private Node buscarMaior(Node no) {
        if (no == null) {
            no = raiz;
        }

        Node atual = no;
        while (atual.getNoDireito() != null) {
            atual = atual.getNoDireito();
        }
        return atual;
    }


    public Node procuraPai(int elemento) {
        Node pai = raiz;
        Node no = buscar(elemento);
        while (pai.getNoDireito() != no && pai.getNoEsquerdo() != no) {
            if (elemento < pai.getInfo()) {
                pai = pai.getNoEsquerdo();
            }
            else if (elemento > pai.getInfo()) {
                pai = pai.getNoDireito();
            }
        }
        return pai;
    }

    public Node removerElemento(int elemento) {
        Node no = buscar(elemento);
        Node ponteiro;
        // Se o nó não existir retorna null
        if (no == null) {
            System.out.println("Elemento não encontrado");
            return null;
        }
        // Parte para percorrer a árvore procurando o pai do elemento
        ponteiro = procuraPai(elemento);
        if (ponteiro.getNoEsquerdo() ==  no) {
            if (noFolha(ponteiro.getNoEsquerdo())) { // Verificando se é nó folha, se for só atribuir null
                ponteiro.setNoEsquerdo(null);
            }
            else if (!noFolha(ponteiro.getNoEsquerdo())) {
                if (no.getNoDireito() != null && no.getNoEsquerdo() != null) { // Aqui verifica se tem dois filhos, se tiver vai ter que fazer mais atribuições
                    Node menor = buscarMenor(no.getNoDireito()); // Procura o menor da direita
                    ponteiro.setNoEsquerdo(menor); // Coloca o menor no lugar
                    insere(no.getNoEsquerdo().getInfo()); // Insere novamente o elemento do nó esquerdo ( só consegui fazer assim)
                }
                else if (no.getNoEsquerdo() == null){ // Verifica se o só tem um filho, sendo o filho esquerdo null
                    ponteiro.setNoEsquerdo(no.getNoDireito()); // Coloca o nó esquerdo do ponteiro como o filho direito do nó removido
                }
                else if (no.getNoDireito() == null) { // Se tem um filho, sendo o filho direito null
                    ponteiro.setNoDireito(no.getNoEsquerdo()); // Coloca o nó direito do ponteiro
                }
            }
        }
        else if (ponteiro.getNoDireito() == no) {
            if (noFolha(ponteiro.getNoDireito())) { // Verificando se é nó folha, se for só atribuir null
                ponteiro.setNoDireito(null);
            }
            else if (!noFolha(ponteiro.getNoDireito())) {
                if (no.getNoDireito() != null && no.getNoEsquerdo() != null) { // Se tem dois filhos
                    Node menor = buscarMenor(no.getNoDireito()); // Procura menor na direita
                    ponteiro.setNoDireito(menor);
                    insere(no.getNoEsquerdo().getInfo()); // Insere novamente o nó esquerdo
                }
                else if (no.getNoEsquerdo() == null) { // Se o nó esquerdo é null
                    ponteiro.setNoEsquerdo(no.getNoDireito()); // Seta o valor do ponteiro esquerdo como o valor do filho direito do nó removido
                }
                else if (no.getNoDireito() == null) { // Se o nó direito é null
                    ponteiro.setNoDireito(no.getNoEsquerdo()); // Seta o valor do ponteiro direito como o valor do filho esquerdo do nó removido
                }
            }
        }
        int balanceamento = fatorBalanceamento(no);
        if (balanceamento > 1 && fatorBalanceamento(no.getNoEsquerdo()) >= 0)
            return rotacaoDireita(no);

        if (balanceamento > 1 && fatorBalanceamento(no.getNoEsquerdo()) < 0) {
            no.setNoEsquerdo(rotacaoEsquerda(no.getNoEsquerdo()));
            return rotacaoDireita(no);
        }

        if (balanceamento < -1 && fatorBalanceamento(no.getNoDireito()) <= 0)
            return rotacaoEsquerda(no);

        if (balanceamento < -1 && fatorBalanceamento(no.getNoDireito()) > 0) {
            no.setNoDireito(rotacaoDireita(no.getNoDireito()));
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void removeMenorElemento() {
        Node no = buscarMenor(null);
        Node ponteiro = procuraPai(no.getInfo());
        ponteiro.setNoEsquerdo(null);
    }

    public void removerMaiorElemento() {
        Node no = buscarMaior(null);
        Node ponteiro = procuraPai(no.getInfo());
        ponteiro.setNoDireito(null);
    }

    public static int altura(Node no) {
        if (no == null) {
            return -1;
        }
        int esquerda = altura(no.getNoEsquerdo());
        int direita = altura(no.getNoDireito());
        if (esquerda > direita) {
            return 1 + esquerda;
        }
        return 1 + direita;
    }

    private int fatorBalanceamento(Node no) {
        if (no == null)
            return 0;
        return altura(no.getNoEsquerdo()) - altura(no.getNoDireito());
    }

    private Node rotacaoDireita(Node no) {
        Node novaRaiz = no.getNoEsquerdo();
        Node temp = novaRaiz.getNoDireito();
        novaRaiz.setNoDireito(no);
        no.setNoEsquerdo(temp);
        return novaRaiz;
    }


    private Node rotacaoEsquerda(Node no) {
        Node novaRaiz = no.getNoDireito();
        Node temp = novaRaiz.getNoEsquerdo();
        novaRaiz.setNoEsquerdo(no);
        no.setNoDireito(temp);
        return novaRaiz;
    }

}
