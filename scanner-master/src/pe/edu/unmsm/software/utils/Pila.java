
package pe.edu.unmsm.software.utils;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Pila<Tipo> implements Iterable<Tipo> {
    private int N; 
    private Nodo<Tipo> inicio;

    private static class Nodo<Item> {
        private Item item;
        private Nodo<Item> prox;
    }

    public Pila() {
        inicio = null;
        N = 0;
    }

    public boolean estaVacia() {
        return inicio == null;
    }

    public int tamanno() {
        return N;
    }

    public void push(Tipo item) {
        Nodo<Tipo> inicioAnterior = inicio;
        inicio = new Nodo<Tipo>();
        inicio.item = item;
        inicio.prox = inicioAnterior;
        N++;
    }

    public Tipo pop() {
        if (estaVacia()) 
            throw new NoSuchElementException("Pila vacía");
        Tipo item = inicio.item;   
        inicio = inicio.prox;    
        N--;
        return item;         
    }

    public Tipo cima() {
        if (estaVacia()) 
            throw new NoSuchElementException("Pila Vacía");
        return inicio.item;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Tipo item : this)
            s.append(item + " ");
        return s.toString();
    }
       
    @Override
    public Iterator<Tipo> iterator() {
        return new IteradorDeLista<Tipo>(inicio);
    }

    private class IteradorDeLista<Item> implements Iterator<Item> {
        private Nodo<Item> actual;

        public IteradorDeLista(Nodo<Item> primero) {
            actual = primero;
        }

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = actual.item;
            actual = actual.prox; 
            return item;
        }
    }
}

