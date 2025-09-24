package co.edu.uniquindio.poo.ListaCircularSimple;

import java.util.Iterator;

public class ListaCircularSimpleIterator<T extends Comparable<T>> implements Iterator<T> {
    private NodoCircular<T> actual;
    private NodoCircular<T> inicio;
    private boolean primeraVez = true;
    public ListaCircularSimpleIterator(NodoCircular<T> nodoPrimero) {
        this.actual = nodoPrimero;
        this.inicio = nodoPrimero;
    }
    @Override
    public boolean hasNext() {
        return actual != null && (primeraVez || actual != inicio);
    }
    @Override
    public T next() {
        T valor = actual.getValor();
        actual = actual.getSiguiente();
        primeraVez = false;
        return valor;
    }
}
