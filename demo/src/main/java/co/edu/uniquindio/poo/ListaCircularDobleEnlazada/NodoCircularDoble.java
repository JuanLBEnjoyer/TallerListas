package co.edu.uniquindio.poo.ListaCircularDobleEnlazada;

public class NodoCircularDoble<T extends Comparable<T>> {
    private T valor;
    private NodoCircularDoble<T> siguiente;
    private NodoCircularDoble<T> anterior;

    public NodoCircularDoble(T valor) {
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }
    public T getValor() {
        return valor;
    }
    public void setValor(T valor) {
        this.valor = valor;
    }
    public NodoCircularDoble<T> getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(NodoCircularDoble<T> siguiente) {
        this.siguiente = siguiente;
    }
    public NodoCircularDoble<T> getAnterior() {
        return anterior;
    }
    public void setAnterior(NodoCircularDoble<T> anterior) {
        this.anterior = anterior;
    }
}
