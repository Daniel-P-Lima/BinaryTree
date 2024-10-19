public class ArvoreBinaria {
    private Node raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public boolean vazia() {
        return this.raiz == null;
    }


    public void insere(int info) {
        if (vazia()) {
            this.raiz = new Node(info);
        }
        else {
            Node ponteiro = raiz;
            while (true) {
                if (info < ponteiro.getInfo()) {
                    if (ponteiro.getNoEsquerdo() == null) {
                        ponteiro.setNoEsquerdo(new Node(info));
                        break;
                    } else {
                        ponteiro = ponteiro.getNoEsquerdo();
                    }
                }
                else if (info > ponteiro.getInfo()) {
                    if (ponteiro.getNoDireito() == null) {
                        ponteiro.setNoDireito(new Node(info));
                        break;
                    } else {
                        ponteiro = ponteiro.getNoDireito();
                    }
                }
                else {
                    break;
                }
            }
        }
    }

    public void preOrdem(Node node){
        if (node == null) {
            node = raiz;
        }
        if (node != null) {
            System.out.println(node.getInfo());
            if (node.getNoEsquerdo() != null) {
                preOrdem(node.getNoEsquerdo());
            }
            if (node.getNoDireito() != null) {
                preOrdem(node.getNoDireito());
            }
        }
    }

    public void inOrdem(Node node) {
        if (node == null) {
            node = raiz;
        }
        if (node != null) {
            if (node.getNoEsquerdo() != null) {
                inOrdem(node.getNoEsquerdo());
            }
            System.out.println(node.getInfo());
            if (node.getNoDireito() != null) {
                inOrdem(node.getNoDireito());
            }
        }
    }

    public void posOrdem(Node node) {
        if (node == null) {
            node = raiz;
        }
        if (node != null) {
            if (node.getNoEsquerdo() != null) {
                posOrdem(node.getNoEsquerdo());
            }
            if (node.getNoDireito() != null) {
                posOrdem(node.getNoDireito());
            }
            System.out.println(node.getInfo());
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
            else if (elemento < ponteiro.getInfo()) {
                ponteiro = ponteiro.getNoEsquerdo();
            }
        }
        if (ponteiro == null) {
            System.out.println("Elemento não encontrado");
        }
        return ponteiro;

    }

    public int quantidadeFilhos(int elemento) {
        Node no = buscar(elemento);
        if (noFolha(no)) {
            System.out.println("Esse elemento tem 0 filhos");
            return 0;
        }
        else if (no.getNoEsquerdo() != null && no.getNoDireito() != null) {
            System.out.println("Esse elemento tem 2 filhos");
            return 2;
        }
        else if (no.getNoDireito() != null || no.getNoEsquerdo() != null) {
            System.out.println("Esse elemento tem 1 filho");
            return 1;
        }
        return 0;

    }

    public int removerElemento(int elemento) {
        Node no = buscar(elemento);
        Node ponteiro = raiz;
        // Se o nó não existir retorna null
        if (no == null) {
            return 1;
        }
        // Caso queira remover a raiz não pode
        if (elemento == raiz.getInfo()) {
            System.out.println("Não foi possível remover a raiz");
            return 1;
        }
        // Parte para percorrer a árvore procurando o pai do elemento
        while (ponteiro.getNoDireito() != no && ponteiro.getNoEsquerdo() != no) {
            if (elemento < ponteiro.getInfo()) {
                ponteiro = ponteiro.getNoEsquerdo();
            }
            else if (elemento > ponteiro.getInfo()) {
                ponteiro = ponteiro.getNoDireito();
            }
        }
        if (ponteiro.getNoEsquerdo() ==  no) {
            if (noFolha(ponteiro.getNoEsquerdo())) { // Verificando se é nó folha, se for só atribuir null
                ponteiro.setNoEsquerdo(null);
            }
            else if (!noFolha(ponteiro.getNoEsquerdo())) {
                if (no.getNoDireito() != null && no.getNoEsquerdo() != null) { // Aqui verifica se tem dois filhos, se tiver vai ter que fazer mais atribuições
                    ponteiro.setNoEsquerdo(no.getNoDireito()); // Coloca o nó esquerdo do ponteiro o nó direito do nó removido
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
                    ponteiro.setNoDireito(no.getNoDireito()); // O ponteiro agora o nó direito dele é o filho do nó removido
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
        return 0;
    }
}
