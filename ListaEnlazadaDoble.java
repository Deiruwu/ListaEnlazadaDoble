public class ListaEnlazadaDoble {
    class Nodo{
        int dato;
        Nodo punteroCabeza = null;
        Nodo punteroCola = null;

        public Nodo(int d){
            dato = d;
        }
    }

    Nodo cabeza = null;
    Nodo cola = null;
    int tamaño = 0;


    public void InsertarAdelante(int d){
        Nodo nuevoNodo = new Nodo(d);
        if (cabeza == null && cola == null){
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            tamaño-=-1;
            return;
        } 
        cabeza.punteroCabeza = nuevoNodo;
        nuevoNodo.punteroCola = cabeza;
        cabeza = nuevoNodo;
        tamaño-=-1;
    }

    public void InsertarAtras(int d){
        Nodo nuevoNodo = new Nodo(d);
        if (cabeza == null && cola == null){
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            tamaño-=-1;
            return;
        } 
        cola.punteroCola = nuevoNodo;
        nuevoNodo.punteroCabeza = cola;
        cola = nuevoNodo;
        tamaño-=-1;
    }

    public void mostrarCabeza(){
        Nodo nodoActual = cabeza;
        while (nodoActual != null){
            System.out.println(nodoActual.dato);
            nodoActual = nodoActual.punteroCola;
        }
    }

    public void mostrarCola(){
        Nodo nodoActual = cola;
        while (nodoActual != null){
            System.out.println(nodoActual.dato);
            nodoActual = nodoActual.punteroCabeza;
        }
    }


    public void eliminarCola(){
        cola = cola.punteroCabeza;
        cola.punteroCola = null;
    }

    public void eliminarCabeza(){
        cabeza = cabeza.punteroCola;
        cabeza.punteroCabeza = null;
    }   

    //=======================================================================================================================
    public Nodo quickSort(Nodo cola, Nodo cabeza) {
        if (cola != null && cabeza != null && cola != cabeza && cola != cabeza.punteroCola) {
            Nodo pivote = particion(cola, cabeza);
            quickSort(cola, pivote.punteroCola); //inicio, pivote -1
            quickSort(pivote.punteroCabeza, cabeza); //pivote +1, fin
        }
        return cabeza;
    }

    // Método para realizar la partición
    private Nodo particion(Nodo cola, Nodo cabeza) {
        Nodo nodoMenor = cola;
        int pivote = cabeza.dato;
        int nodoAuxiliar;

        for (Nodo i = cola; i != cabeza; i = i.punteroCabeza) {

            if (i.dato <= pivote) {

                nodoAuxiliar = nodoMenor.dato;

                nodoMenor.dato = i.dato;
                i.dato = nodoAuxiliar;
                nodoMenor = nodoMenor.punteroCabeza;

            }
        }
        nodoAuxiliar = nodoMenor.dato;
        nodoMenor.dato = cabeza.dato;
        cabeza.dato = nodoAuxiliar;
        return nodoMenor;
    }

    public void printList(Nodo nodo) {
        if (nodo != null) {
            printList(nodo.punteroCola);
            System.out.print(nodo.dato + " ");
        }
    }
    //=======================================================================================================================
    public static void main(String[] args) {
        ListaEnlazadaDoble list = new ListaEnlazadaDoble();
        list.InsertarAdelante(5);
        list.InsertarAtras(2);
        list.InsertarAtras(1);
        list.InsertarAdelante(7);
        list.InsertarAdelante(4);
        list.InsertarAtras(3);
        list.InsertarAdelante(6);

        list.printList(list.cabeza);

        list.quickSort(list.cola, list.cabeza);

        System.out.println("\nLista ordenada");
        list.printList(list.cabeza);
    
    }
}