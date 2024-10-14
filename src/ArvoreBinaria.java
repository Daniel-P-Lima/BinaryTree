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
        System.out.println(node.getInfo());
        if (node.getNoEsquerdo() != null) {
            preOrdem(node.getNoEsquerdo());
        }
        if (node.getNoDireito() != null) {
            preOrdem(node.getNoDireito());
        }
    }

    public void inOrdem(Node node) {
        if (node == null) {
            node = raiz;
        }
        if (node.getNoEsquerdo() != null) {
            inOrdem(node.getNoEsquerdo());
        }
        System.out.println(node.getInfo());
        if (node.getNoDireito() != null) {
            inOrdem(node.getNoDireito());
        }
    }

    public void posOrdem(Node node) {
        if (node == null) {
            node = raiz;
        }
        if (node.getNoEsquerdo() != null) {
            posOrdem(node.getNoEsquerdo());
        }
        if (node.getNoDireito() != null) {
            posOrdem(node.getNoDireito());
        }
        System.out.println(node.getInfo());
    }
}
