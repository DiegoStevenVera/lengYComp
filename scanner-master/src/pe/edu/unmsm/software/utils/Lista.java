/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.software.utils;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author diego
 */
public class Lista<Item> implements Iterable<Item>{
    private Nodo<Item> cabecera;
    private Comparator comp;
    
    public Lista() {
        cabecera = null;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterador<Item>();
    }
    
    private class Nodo<Item> {
        private Item item;
        private Nodo sgt;
        
        public Nodo(Item item) {
            this.item = item;
            this.sgt = null;
        }
    }
    
    private class Iterador<Item> implements Iterator<Item> {

        private Nodo<Item> act;
        
        public Iterador() {
            act = (Nodo<Item>) cabecera;
        }
        
        @Override
        public boolean hasNext() {
            return act != null;
        }

        @Override
        public Item next() {
            Item item = act.item;
            act = act.sgt;
            return item;
        }
        
    }
    
    public void agregar(Item nuevo) {
        Nodo<Item> nNuevo = new Nodo<>(nuevo);
        if (cabecera == null) {
            cabecera = nNuevo;
        } else {
            Nodo<Item> act = cabecera;
            while (act.sgt != null) {
                act = act.sgt;
            }
            act.sgt = nNuevo;
        }
    }
    
    @Override
    public String toString() {
        Nodo<Item> p = cabecera;
        String cad = "";
        
        while(p != null) {
            cad += p.item + "\n";
            p = p.sgt;
        }
        return cad;
    }
}
