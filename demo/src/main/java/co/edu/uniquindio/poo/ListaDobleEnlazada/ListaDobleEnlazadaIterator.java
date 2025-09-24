package co.edu.uniquindio.poo.ListaDobleEnlazada;

import java.util.Iterator;

public class ListaDobleEnlazadaIterator<T extends Comparable<T>> implements Iterator<T> {
    private NodoDoble<T> actual;
    public ListaDobleEnlazadaIterator(NodoDoble<T> nodoPrimero) {
        this.actual = nodoPrimero;
    }
    @Override
    public boolean hasNext() {
        return actual != null;
    }
    @Override
    public T next() {
        T valor = actual.getValor();
        actual = actual.getSiguiente();
        return valor;
    }
}
