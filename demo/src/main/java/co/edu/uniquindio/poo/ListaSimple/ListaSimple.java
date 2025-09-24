package co.edu.uniquindio.poo.ListaSimple;

import java.util.Iterator;

public class ListaSimple<T extends Comparable<T>> implements Iterable<T> {

    private int size;
    private Nodo<T> nodoPrimero;


    public ListaSimple(){
        this.size = 0;
        this.nodoPrimero = null;
    }


    public int getSize() {
        return size;
    }

    public void addPrimero(T valor){
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if(nodoPrimero == null){
            nodoPrimero = nuevoNodo;
        }else{
            nuevoNodo.setSiguiente(nodoPrimero);
            nodoPrimero = nuevoNodo;
        }
        size++;
    }


    public void addUltimo(T valor) {
        Nodo<T> nodo = new Nodo<>(valor);
        if (nodoPrimero == null) {
            nodoPrimero = nodo;
        } else {
            Nodo<T> nodoRef = nodoPrimero;
            while (nodoRef.getSiguiente() != null) {
                nodoRef = nodoRef.getSiguiente();
            }
            nodoRef.setSiguiente(nodo);
        }
        size++;
    }

    public void addIndex(int index, T valor){
        if(index < 0 || index > size){
            System.out.println("Indice fuera de rango");
        }
        if(index == 0){
            addPrimero(valor);
        }
        else{
            Nodo<T> nodo = new Nodo<>(valor);
            Nodo<T> nodoRef = nodoPrimero;
            for(int i = 0; i < index - 1; i++){
                nodoRef = nodoRef.getSiguiente();
            }
            nodo.setSiguiente(nodoRef.getSiguiente());
            nodoRef.setSiguiente(nodo);
        }
        size++;
    }

    public T obtenerValor(int index){
        if(index < 0 || index >= size){
            System.out.println("Indice fuera de rango");
            return null;
        }
        Nodo<T> nodoRef = nodoPrimero;
        for(int i = 0; i < index-1; i++){
            nodoRef = nodoRef.getSiguiente();
        }
        return nodoRef.getValor();
    }

    public Nodo<T> obtenerNodo(int index){
        if(index < 0 || index >= size){
            System.out.println("Indice fuera de rango");
            return null;
        }
        if(index == 0){
            return nodoPrimero;
        }
        Nodo<T> nodoRef = nodoPrimero;
        for(int i = 0; i < index-1; i++){
            nodoRef = nodoRef.getSiguiente();
        }
        return nodoRef;
    }

    public int obtenerPosicionNodo(T valor){
        Nodo<T> nodoRef = nodoPrimero;
        for(int i = 0; i < size; i++){
            if(nodoRef.getValor().equals(valor)){
                return i;
            }
            nodoRef = nodoRef.getSiguiente();
        }
        return -1;
    }

    public void indiceValido(int index){
        if(index < 0 || index >= size){
            System.out.println("Indice fuera de rango");
        }
    }
    public boolean estaVacia(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

    public void eliminarPrimero(){
        if(estaVacia()){
            System.out.println("La lista esta vacia");
        }else{
            nodoPrimero = nodoPrimero.getSiguiente();
            size--;
        }
    }

    public void eliminarUltimo(){
        if(estaVacia()){
            System.out.println("La lista esta vacia");
        }else{
            if(size == 1){
                nodoPrimero = null;
            }else{
                Nodo<T> nodoRef = nodoPrimero;
                for(int i = 0; i < size - 2; i++){
                    nodoRef = nodoRef.getSiguiente();
                }
                nodoRef.setSiguiente(null);
            }
            size--;
        }
    }

    public void eliminarDadoValor(T valor){
        if(estaVacia()){
            System.out.println("La lista esta vacia");
        }else{
            if(nodoPrimero.getValor().equals(valor)){
                eliminarPrimero();
            }else{
                Nodo<T> nodoRef = nodoPrimero;
                while(nodoRef.getSiguiente() != null && !nodoRef.getSiguiente().getValor().equals(valor)){
                    nodoRef = nodoRef.getSiguiente();
                }
                if(nodoRef.getSiguiente() != null){
                    nodoRef.setSiguiente(nodoRef.getSiguiente().getSiguiente());
                    size--;
                }else{
                    System.out.println("El valor no se encuentra en la lista");
                }
            }
        }
    }

    public void modificarNodo(int index, T valor){
        if(index < 0 || index >= size){
            System.out.println("Indice fuera de rango");
        }else{
            Nodo<T> nodoRef = nodoPrimero;
            for(int i = 0; i < index-1; i++){
                nodoRef = nodoRef.getSiguiente();
            }
            nodoRef.setValor(valor);
        }
    }

    public void ordenarLista() {
        if (size < 2) return;
        Nodo<T> actual = nodoPrimero;
        while (actual != null) {
            Nodo<T> siguiente = actual.getSiguiente();
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

    public void imprimirLista(){
        if(estaVacia()){
            System.out.println("La lista esta vacia");
        }else{
            Nodo<T> nodoRef = nodoPrimero;
            for(int i = 0; i < size; i++){
                System.out.print(nodoRef.getValor() + " ");
                nodoRef = nodoRef.getSiguiente();
            }
            System.out.println();
        }
    }

    public void eliminarLista(){
        nodoPrimero = null;
        size = 0;
    }


    @Override
    public Iterator<T> iterator() {
        return new ListaSimpleIterator<>(nodoPrimero);
    }

    public void invertirListaRecursivo(){}

}