public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.insere(40);
        arvoreBinaria.insere(20);
        arvoreBinaria.insere(60);
        arvoreBinaria.insere(10);
        arvoreBinaria.insere(30);
        arvoreBinaria.insere(50);
        arvoreBinaria.insere(70);
        arvoreBinaria.insere(80);
        arvoreBinaria.insere(25);
        arvoreBinaria.insere(15);
        arvoreBinaria.insere(90);
        arvoreBinaria.insere(85);
        arvoreBinaria.insere(86);
        arvoreBinaria.insere(97);
        arvoreBinaria.preOrdem(null);
        System.out.println();
        arvoreBinaria.inOrdem(null);
        System.out.println();
        arvoreBinaria.posOrdem(null);
        //arvoreBinaria.buscar(12);
        //arvoreBinaria.quantidadeFilhos(7);
        System.out.println();
        arvoreBinaria.removerElemento(85);
        arvoreBinaria.inOrdem(null);
        System.out.println();
    }
}
