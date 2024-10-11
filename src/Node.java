public class Node {
    private int info;
    private Node noDireito;
    private Node noEsquerdo;

    public Node(int info) {
        this.info = info;
        this.noDireito = null;
        this.noEsquerdo = null;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(Node noDireito) {
        this.noDireito = noDireito;
    }

    public Node getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(Node noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }
}
