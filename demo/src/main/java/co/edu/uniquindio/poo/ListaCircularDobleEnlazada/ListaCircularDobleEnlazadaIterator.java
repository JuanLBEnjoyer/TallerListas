package co.edu.uniquindio.poo.ListaCircularDobleEnlazada;

import java.util.Iterator;

public class ListaCircularDobleEnlazadaIterator<T extends Comparable<T>> implements Iterator<T> {
    private NodoCircularDoble<T> actual;
    private NodoCircularDoble<T> inicio;
    private boolean primeraVez = true;
    public ListaCircularDobleEnlazadaIterator(NodoCircularDoble<T> nodoPrimero) {
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
