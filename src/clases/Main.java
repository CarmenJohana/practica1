package clases;

public class Main {

    public static void main(String[] args) {
        // Crear una pila con capacidad para 3 elementos
        Queue cola = new Queue();
        cola.enqueue(4);
        cola.enqueue(8);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(5);

        // Eliminar todos los elementos de la pila
        while (!cola.isEmpty()) {
            System.out.println(cola.dequeue());
        }

        System.out.println(cola.first());


    }



}
