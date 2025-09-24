package co.edu.uniquindio.poo.ListaCircularSimple;

public class Prueba {
    public static void main(String[] args) {
        ListaCircularSimple<Integer> lista = new ListaCircularSimple<>();
        lista.agregarInicio(3);
        lista.agregarFinal(5);
        lista.agregar(1, 4);
        lista.imprimirLista();
        lista.modificarNodo(1, 10);
        lista.imprimirLista();
        lista.eliminar(3);
        lista.imprimirLista();
        lista.ordenarLista();
        lista.imprimirLista();
        System.out.println("Iterando:");
        for (Integer val : lista) {
            System.out.print(val + " ");
        }
        System.out.println();
        lista.borrarLista();
        lista.imprimirLista();
    }
}
