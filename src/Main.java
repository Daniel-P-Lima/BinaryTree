public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.insere(40);
        arvoreBinaria.insere(20);
        arvoreBinaria.insere(60);
        arvoreBinaria.insere(10);
        arvoreBinaria.insere(30);
        arvoreBinaria.insere(39);
        arvoreBinaria.insere(50);
        arvoreBinaria.insere(70);
        arvoreBinaria.insere(80);
        arvoreBinaria.insere(25);
        arvoreBinaria.insere(15);
        arvoreBinaria.insere(90);
        arvoreBinaria.insere(85);
        arvoreBinaria.insere(86);
        arvoreBinaria.insere(97);
        System.out.println("Pré ordem:");
        arvoreBinaria.preOrdem(null);
        System.out.println("In ordem:");
        arvoreBinaria.inOrdem(null);
        System.out.println("Pós ordem:");
        arvoreBinaria.posOrdem(null);
        //arvoreBinaria.buscar(12);
        System.out.println();
        //arvoreBinaria.removerElemento(30);
        arvoreBinaria.inOrdem(null);
        System.out.println();
        arvoreBinaria.posOrdem(null);
        System.out.println();
        //arvoreBinaria.removeMenorElemento();
        System.out.println();
        arvoreBinaria.inOrdem(null);
        System.out.println();
        //arvoreBinaria.removerMaiorElemento();
        arvoreBinaria.inOrdem(null);
        System.out.println();
        arvoreBinaria.removerElemento(97);
        System.out.println();
        arvoreBinaria.inOrdem(null);
    }
}
