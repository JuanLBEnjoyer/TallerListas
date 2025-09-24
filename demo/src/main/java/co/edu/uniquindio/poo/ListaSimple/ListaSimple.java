package co.edu.uniquindio.poo.ListaSimple;

public class ListaSimple<T> {

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
        Nodo nuevoNodo = new Nodo(valor);
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
        for(int i = 0; i < index; i++){
            nodoRef = nodoRef.getSiguiente();
        }
        return  (T) nodoRef.getValor();
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
        for(int i = 0; i < index; i++){
            nodoRef = nodoRef.getSiguiente();
        }
        return  nodoRef;
    }
}