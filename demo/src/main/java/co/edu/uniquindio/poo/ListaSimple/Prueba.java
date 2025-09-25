package co.edu.uniquindio.poo.ListaSimple;

public class Prueba {
    public static void main(String[] args) {
        ListaSimple<Integer> lista = new ListaSimple<>();
        lista.addUltimo(10);
        lista.addUltimo(20);
        lista.addUltimo(30);
        lista.addUltimo(40);
        lista.addUltimo(50);


        lista.imprimirLista();
        lista.invertir();
        lista.imprimirLista();

        
    }
}
