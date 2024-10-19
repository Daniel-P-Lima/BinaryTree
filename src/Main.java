public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.insere(4);
        arvoreBinaria.insere(2);
        arvoreBinaria.insere(6);
        arvoreBinaria.insere(1);
        arvoreBinaria.insere(3);
        arvoreBinaria.insere(5);
        arvoreBinaria.insere(7);
        arvoreBinaria.insere(8);
        arvoreBinaria.preOrdem(null);
        System.out.println();
        arvoreBinaria.inOrdem(null);
        System.out.println();
        arvoreBinaria.posOrdem(null);
        //arvoreBinaria.buscar(12);
        //arvoreBinaria.quantidadeFilhos(7);
        System.out.println();
        arvoreBinaria.removerElemento(8);
        arvoreBinaria.inOrdem(null);
    }
}
