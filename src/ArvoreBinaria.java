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
            Node novoNo = new Node(info);
            this.raiz = novoNo;
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


    public void preOrdem() {
        Node ponteiro = raiz;
        System.out.println(raiz.getInfo());
        if (raiz.getNoEsquerdo() != null || raiz.getNoDireito() != null) {
            raiz = raiz.getNoEsquerdo();
            System.out.println(raiz.getInfo());
            raiz = raiz.getNoEsquerdo();
            preOrdem();

        }
        else {
            if(raiz.getNoEsquerdo() == null) {
                raiz = raiz.getNoDireito();
            }
        }
    }
}
