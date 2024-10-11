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
        if (raiz.getNoEsquerdo() != null || raiz.getNoDireito() != null) {
            System.out.println(raiz.getInfo());
            Node ponteiro = raiz.getNoEsquerdo();
            System.out.println(ponteiro.getInfo());
            raiz = raiz.getNoEsquerdo();
            preOrdem();
            System.out.println(ponteiro.getInfo());

        }
        else {
            raiz = raiz.getNoDireito();
            preOrdem();
        }
    }
}
