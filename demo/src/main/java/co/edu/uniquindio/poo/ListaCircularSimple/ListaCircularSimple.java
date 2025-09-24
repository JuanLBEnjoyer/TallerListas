package co.edu.uniquindio.poo.ListaCircularSimple;

import java.util.Iterator;

public class ListaCircularSimple<T extends Comparable<T>> implements Iterable<T> {
    private int size;
    private NodoCircular<T> nodoPrimero;

    public ListaCircularSimple() {
        this.size = 0;
        this.nodoPrimero = null;
    }

    public int getSize() {
        return size;
    }

    public void agregarInicio(T valor) {
        NodoCircular<T> nuevoNodo = new NodoCircular<>(valor);
        if (nodoPrimero == null) {
            nodoPrimero = nuevoNodo;
            nuevoNodo.setSiguiente(nodoPrimero);
        } else {
            NodoCircular<T> ultimo = nodoPrimero;
            while (ultimo.getSiguiente() != nodoPrimero) {
                ultimo = ultimo.getSiguiente();
            }
            nuevoNodo.setSiguiente(nodoPrimero);
            nodoPrimero = nuevoNodo;
            ultimo.setSiguiente(nodoPrimero);
        }
        size++;
    }

    public void agregarFinal(T valor) {
        NodoCircular<T> nuevoNodo = new NodoCircular<>(valor);
        if (nodoPrimero == null) {
            nodoPrimero = nuevoNodo;
            nuevoNodo.setSiguiente(nodoPrimero);
        } else {
            NodoCircular<T> ultimo = nodoPrimero;
            while (ultimo.getSiguiente() != nodoPrimero) {
                ultimo = ultimo.getSiguiente();
            }
            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setSiguiente(nodoPrimero);
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
        NodoCircular<T> nuevoNodo = new NodoCircular<>(valor);
        NodoCircular<T> nodoRef = nodoPrimero;
        for (int i = 0; i < index - 1; i++) {
            nodoRef = nodoRef.getSiguiente();
        }
        nuevoNodo.setSiguiente(nodoRef.getSiguiente());
        nodoRef.setSiguiente(nuevoNodo);
        size++;
    }

    public T obtenerValorNodo(int index) {
        NodoCircular<T> nodo = obtenerNodo(index);
        return nodo != null ? nodo.getValor() : null;
    }

    public NodoCircular<T> obtenerNodo(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Indice fuera de rango");
            return null;
        }
        NodoCircular<T> nodoRef = nodoPrimero;
        for (int i = 0; i < index; i++) {
            nodoRef = nodoRef.getSiguiente();
        }
        return nodoRef;
    }

    public int obtenerPosicionNodo(T valor) {
        NodoCircular<T> nodoRef = nodoPrimero;
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
            NodoCircular<T> ultimo = nodoPrimero;
            while (ultimo.getSiguiente() != nodoPrimero) {
                ultimo = ultimo.getSiguiente();
            }
            nodoPrimero = nodoPrimero.getSiguiente();
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
            NodoCircular<T> nodoRef = nodoPrimero;
            while (nodoRef.getSiguiente().getSiguiente() != nodoPrimero) {
                nodoRef = nodoRef.getSiguiente();
            }
            nodoRef.setSiguiente(nodoPrimero);
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
        NodoCircular<T> nodoRef = nodoPrimero;
        while (nodoRef.getSiguiente() != nodoPrimero && !nodoRef.getSiguiente().getValor().equals(valor)) {
            nodoRef = nodoRef.getSiguiente();
        }
        if (nodoRef.getSiguiente() != nodoPrimero) {
            nodoRef.setSiguiente(nodoRef.getSiguiente().getSiguiente());
            size--;
        } else {
            System.out.println("El valor no se encuentra en la lista");
        }
    }

    public void modificarNodo(int index, T valor) {
        NodoCircular<T> nodo = obtenerNodo(index);
        if (nodo != null) {
            nodo.setValor(valor);
        }
    }

    public void ordenarLista() {
        if (size < 2) return;
        NodoCircular<T> actual = nodoPrimero;
        for (int i = 0; i < size - 1; i++) {
            NodoCircular<T> siguiente = actual.getSiguiente();
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
            NodoCircular<T> nodoRef = nodoPrimero;
            for (int i = 0; i < size; i++) {
                System.out.print(nodoRef.getValor() + " ");
                nodoRef = nodoRef.getSiguiente();
            }
            System.out.println();
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ListaCircularSimpleIterator<>(nodoPrimero);
    }

    public void borrarLista() {
        nodoPrimero = null;
        size = 0;
    }
}
