package co.edu.uniquindio.poo.ListaDobleEnlazada;

import java.util.Iterator;

public class ListaDobleEnlazada<T extends Comparable<T>> implements Iterable<T> {
    private int size;
    private NodoDoble<T> nodoPrimero;
    private NodoDoble<T> nodoUltimo;

    public ListaDobleEnlazada() {
        this.size = 0;
        this.nodoPrimero = null;
        this.nodoUltimo = null;
    }

    public int getSize() {
        return size;
    }

    public void agregarInicio(T valor) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(valor);
        if (nodoPrimero == null) {
            nodoPrimero = nodoUltimo = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(nodoPrimero);
            nodoPrimero.setAnterior(nuevoNodo);
            nodoPrimero = nuevoNodo;
        }
        size++;
    }

    public void agregarFinal(T valor) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(valor);
        if (nodoUltimo == null) {
            nodoPrimero = nodoUltimo = nuevoNodo;
        } else {
            nodoUltimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(nodoUltimo);
            nodoUltimo = nuevoNodo;
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
        NodoDoble<T> nuevoNodo = new NodoDoble<>(valor);
        NodoDoble<T> nodoRef = nodoPrimero;
        for (int i = 0; i < index - 1; i++) {
            nodoRef = nodoRef.getSiguiente();
        }
        nuevoNodo.setSiguiente(nodoRef.getSiguiente());
        nuevoNodo.setAnterior(nodoRef);
        nodoRef.getSiguiente().setAnterior(nuevoNodo);
        nodoRef.setSiguiente(nuevoNodo);
        size++;
    }

    public T obtenerValorNodo(int index) {
        NodoDoble<T> nodo = obtenerNodo(index);
        return nodo != null ? nodo.getValor() : null;
    }

    public NodoDoble<T> obtenerNodo(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indice fuera de rango");
            return null;
        }
        NodoDoble<T> nodoRef = nodoPrimero;
        for (int i = 0; i < index; i++) {
            nodoRef = nodoRef.getSiguiente();
        }
        return nodoRef;
    }

    public int obtenerPosicionNodo(T valor) {
        NodoDoble<T> nodoRef = nodoPrimero;
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
            nodoPrimero = nodoUltimo = null;
        } else {
            nodoPrimero = nodoPrimero.getSiguiente();
            nodoPrimero.setAnterior(null);
        }
        size--;
    }

    public void eliminarUltimo() {
        if (estaVacia()) {
            System.out.println("La lista esta vacia");
            return;
        }
        if (size == 1) {
            nodoPrimero = nodoUltimo = null;
        } else {
            nodoUltimo = nodoUltimo.getAnterior();
            nodoUltimo.setSiguiente(null);
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
        NodoDoble<T> nodoRef = nodoPrimero;
        while (nodoRef.getSiguiente() != null && !nodoRef.getSiguiente().getValor().equals(valor)) {
            nodoRef = nodoRef.getSiguiente();
        }
        if (nodoRef.getSiguiente() != null) {
            NodoDoble<T> nodoEliminar = nodoRef.getSiguiente();
            nodoRef.setSiguiente(nodoEliminar.getSiguiente());
            if (nodoEliminar.getSiguiente() != null) {
                nodoEliminar.getSiguiente().setAnterior(nodoRef);
            } else {
                nodoUltimo = nodoRef;
            }
            size--;
        } else {
            System.out.println("El valor no se encuentra en la lista");
        }
    }

    public void modificarNodo(int index, T valor) {
        NodoDoble<T> nodo = obtenerNodo(index);
        if (nodo != null) {
            nodo.setValor(valor);
        }
    }

    public void ordenarLista() {
        if (size < 2) return;
        NodoDoble<T> actual = nodoPrimero;
        while (actual != null) {
            NodoDoble<T> siguiente = actual.getSiguiente();
            while (siguiente != null) {
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
            NodoDoble<T> nodoRef = nodoPrimero;
            for (int i = 0; i < size; i++) {
                System.out.print(nodoRef.getValor() + " ");
                nodoRef = nodoRef.getSiguiente();
            }
            System.out.println();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListaDobleEnlazadaIterator<>(nodoPrimero);
    }

    public void borrarLista() {
        nodoPrimero = nodoUltimo = null;
        size = 0;
    }
}
