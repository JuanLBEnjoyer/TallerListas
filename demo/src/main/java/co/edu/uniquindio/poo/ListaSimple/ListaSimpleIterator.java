package co.edu.uniquindio.poo.ListaSimple;

import java.util.Iterator;

public class ListaSimpleIterator<T extends Comparable<T>> implements Iterator<T> {
    private Nodo<T> actual;
    public ListaSimpleIterator(Nodo<T> nodoPrimero) {
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
