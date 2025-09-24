package co.edu.uniquindio.poo.ListaSimple;

public class Prueba {

    public static void main(String[] args) {
        ListaSimple<Integer> lista = new ListaSimple<>();
        lista.addPrimero(1);
        lista.addUltimo(2);
        lista.addIndex(0,3);
        System.out.println(lista.obtenerValor(2));
        System.out.println(lista.obtenerNodo(2).getValor());
    }

    
    
}
