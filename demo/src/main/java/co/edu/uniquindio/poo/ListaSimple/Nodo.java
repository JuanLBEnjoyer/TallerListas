package co.edu.uniquindio.poo.ListaSimple;

public class Nodo<T extends Comparable<T>> implements Comparable<Nodo<T>> {
    private T valor;
    private Nodo<T> siguiente;

    public Nodo(T valor) {
        this.valor = valor;
        this.siguiente = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public int compareTo(Nodo<T> otro) {
        return this.valor.compareTo(otro.valor);
    }

}
