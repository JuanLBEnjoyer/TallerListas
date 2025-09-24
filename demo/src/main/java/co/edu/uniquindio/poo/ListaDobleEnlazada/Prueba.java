package co.edu.uniquindio.poo.ListaDobleEnlazada;

public class Prueba {
    public static void main(String[] args) {
        ListaDobleEnlazada<Integer> lista = new ListaDobleEnlazada<>();
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
