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
            if (info > raiz.getInfo()) {
                if (ponteiro.getNoDireito() == null) {
                    ponteiro.setNoDireito(new Node(info));
                }
                else {
                    while (info > ponteiro.getInfo() && ponteiro.getNoDireito() != null) {
                        ponteiro = ponteiro.getNoDireito();
                    }
                    if (info > ponteiro.getInfo()) {
                        ponteiro.setNoDireito(new Node(info));
                    }
                }
            }
            else if (info < raiz.getInfo()) {
                if (ponteiro.getNoEsquerdo() == null) {
                    ponteiro.setNoEsquerdo(new Node (info));
                }
                else {
                    while (info < ponteiro.getInfo() && ponteiro.getNoEsquerdo() != null) {
                        ponteiro = ponteiro.getNoEsquerdo();
                    }
                    if (info > ponteiro.getInfo()) {
                        ponteiro.setNoDireito(new Node(info));
                    }
                    else if (info < ponteiro.getInfo()) {
                        ponteiro.setNoEsquerdo(new Node(info));
                    }
                }
            }
        }
    }

    public void inOrdem(Node node) {
        if(node == null) {
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
}
