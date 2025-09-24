package co.edu.uniquindio.poo.ListaCircularDobleEnlazada;

import java.util.Iterator;

public class ListaCircularDobleEnlazada<T extends Comparable<T>> implements Iterable<T> {
    private int size;
    private NodoCircularDoble<T> nodoPrimero;

    public ListaCircularDobleEnlazada() {
        this.size = 0;
        this.nodoPrimero = null;
    }

    public int getSize() {
        return size;
    }

    public void agregarInicio(T valor) {
        NodoCircularDoble<T> nuevoNodo = new NodoCircularDoble<>(valor);
        if (nodoPrimero == null) {
            nodoPrimero = nuevoNodo;
            nuevoNodo.setSiguiente(nodoPrimero);
            nuevoNodo.setAnterior(nodoPrimero);
        } else {
            NodoCircularDoble<T> ultimo = nodoPrimero.getAnterior();
            nuevoNodo.setSiguiente(nodoPrimero);
            nuevoNodo.setAnterior(ultimo);
            nodoPrimero.setAnterior(nuevoNodo);
            ultimo.setSiguiente(nuevoNodo);
            nodoPrimero = nuevoNodo;
        }
        size++;
    }

    public void agregarFinal(T valor) {
        NodoCircularDoble<T> nuevoNodo = new NodoCircularDoble<>(valor);
        if (nodoPrimero == null) {
            nodoPrimero = nuevoNodo;
            nuevoNodo.setSiguiente(nodoPrimero);
            nuevoNodo.setAnterior(nodoPrimero);
        } else {
            NodoCircularDoble<T> ultimo = nodoPrimero.getAnterior();
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            nuevoNodo.setSiguiente(nodoPrimero);
            nodoPrimero.setAnterior(nuevoNodo);
        }
        size++;
    }

    public void agregar(int index, T valor) {
        if (index < 0 || index > size) {
            System.out.println("Indice fuera de rango");
            return;
        }
        if (index == 0) {
            agregarInicio(valor);
            return;
        }
        if (index == size) {
            agregarFinal(valor);
            return;
        }
        NodoCircularDoble<T> nuevoNodo = new NodoCircularDoble<>(valor);
        NodoCircularDoble<T> nodoRef = nodoPrimero;
        for (int i = 0; i < index - 1; i++) {
            nodoRef = nodoRef.getSiguiente();
        }
        NodoCircularDoble<T> siguiente = nodoRef.getSiguiente();
        nodoRef.setSiguiente(nuevoNodo);
        nuevoNodo.setAnterior(nodoRef);
        nuevoNodo.setSiguiente(siguiente);
        siguiente.setAnterior(nuevoNodo);
        size++;
    }

    public T obtenerValorNodo(int index) {
        NodoCircularDoble<T> nodo = obtenerNodo(index);
        return nodo != null ? nodo.getValor() : null;
    }

    public NodoCircularDoble<T> obtenerNodo(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indice fuera de rango");
            return null;
        }
        NodoCircularDoble<T> nodoRef = nodoPrimero;
        for (int i = 0; i < index; i++) {
            nodoRef = nodoRef.getSiguiente();
        }
        return nodoRef;
    }

    public int obtenerPosicionNodo(T valor) {
        NodoCircularDoble<T> nodoRef = nodoPrimero;
        for (int i = 0; i < size; i++) {
            if (nodoRef.getValor().equals(valor)) {
                return i;
            }
            nodoRef = nodoRef.getSiguiente();
        }
        return -1;
    }

    public void indiceValido(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indice fuera de rango");
        }
    }

    public boolean estaVacia() {
        return size == 0;
    }

    public void eliminarPrimero() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
            return;
        }
        if (size == 1) {
            nodoPrimero = null;
        } else {
            NodoCircularDoble<T> ultimo = nodoPrimero.getAnterior();
            nodoPrimero = nodoPrimero.getSiguiente();
            nodoPrimero.setAnterior(ultimo);
            ultimo.setSiguiente(nodoPrimero);
        }
        size--;
    }

    public void eliminarUltimo() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
            return;
        }
        if (size == 1) {
            nodoPrimero = null;
        } else {
            NodoCircularDoble<T> ultimo = nodoPrimero.getAnterior();
            NodoCircularDoble<T> nuevoUltimo = ultimo.getAnterior();
            nuevoUltimo.setSiguiente(nodoPrimero);
            nodoPrimero.setAnterior(nuevoUltimo);
        }
        size--;
    }

    public void eliminar(T valor) {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
            return;
        }
        if (nodoPrimero.getValor().equals(valor)) {
            eliminarPrimero();
            return;
        }
        NodoCircularDoble<T> nodoRef = nodoPrimero;
        for (int i = 0; i < size; i++) {
            if (nodoRef.getSiguiente().getValor().equals(valor)) {
                NodoCircularDoble<T> eliminar = nodoRef.getSiguiente();
                nodoRef.setSiguiente(eliminar.getSiguiente());
                eliminar.getSiguiente().setAnterior(nodoRef);
                size--;
                return;
            }
            nodoRef = nodoRef.getSiguiente();
        }
        System.out.println("El valor no se encuentra en la lista");
    }

    public void modificarNodo(int index, T valor) {
        NodoCircularDoble<T> nodo = obtenerNodo(index);
        if (nodo != null) {
            nodo.setValor(valor);
        }
    }

    public void ordenarLista() {
        if (size < 2) return;
        NodoCircularDoble<T> actual = nodoPrimero;
        for (int i = 0; i < size - 1; i++) {
            NodoCircularDoble<T> siguiente = actual.getSiguiente();
            for (int j = i + 1; j < size; j++) {
                if (actual.getValor().compareTo(siguiente.getValor()) > 0) {
                    T temp = actual.getValor();
                    actual.setValor(siguiente.getValor());
                    siguiente.setValor(temp);
                }
                siguiente = siguiente.getSiguiente();
            }
            actual = actual.getSiguiente();
        }
    }

    public void imprimirLista() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
        } else {
            NodoCircularDoble<T> nodoRef = nodoPrimero;
            for (int i = 0; i < size; i++) {
                System.out.print(nodoRef.getValor() + " ");
                nodoRef = nodoRef.getSiguiente();
            }
            System.out.println();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListaCircularDobleEnlazadaIterator<>(nodoPrimero);
    }

    public void borrarLista() {
        nodoPrimero = null;
        size = 0;
    }
}
