/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.software.utils;

import java.util.Comparator;

/**
 *
 * @author diego
 */
public class Identificador implements Comparable<Identificador>{
    private String id;
    private String nombre;
    private String tipo;
    
    public final static Comparador COMPARADOR_TIPO = new Comparador();
    public final static ComparadorNombre COMPARADOR_NOMBRE = new ComparadorNombre();
    
    public Identificador(String id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public Identificador(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Identificador o) {
        if (this.tipo.compareTo(o.tipo) > 0) {
            return 1;
        } else if (this.tipo.compareTo(o.tipo) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
    
    public static class Comparador implements Comparator<Identificador> {

        @Override
        public int compare(Identificador o1, Identificador o2) {
            return o1.compareTo(o2);
        }
    }
    
    public static class ComparadorNombre implements Comparator<String>{

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
        
        
    }
    
    @Override
    public String toString() {
        return id;
    }
}
