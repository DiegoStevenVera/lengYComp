/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.software.views;
import java.util.Iterator;
import pe.edu.unmsm.software.utils.ControlarArchivo;
import pe.edu.unmsm.software.utils.Identificador;
import pe.edu.unmsm.software.utils.Lista;

/**
 *
 * @author diego
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static int contadorTipo(String tipo, Lista<Identificador> list) {
        Iterator<Identificador> it = list.iterator();
        Identificador o = new Identificador(tipo);
        int cant = 0;
        
        while (it.hasNext()) {
            if (it.next().compareTo(o) == 0) {
                cant++;
            }
        }
        return cant;
    }
    
    public static void main(String[] args) {
        String token = "";
        String tipo = "";
        String id = "";
        boolean encontrado = false;
        
        Lista<Identificador> list = new Lista<>();
        Lista<String> archivo;
        ControlarArchivo ca = new ControlarArchivo();
        Iterator<String> it;
        
        
        ca.leerArchivo();
        archivo = ca.getLista();
        it = archivo.iterator();
        
        while (it.hasNext()) {
            token = it.next();
            
            switch (token) {
                case "int":     id = "I"; encontrado = true;
                                break;
                case "String":  id = "S";  encontrado = true; 
                                break;
                case "char":    id = "C";  encontrado = true; 
                                break;
                case "float":   id = "F";  encontrado = true;
                                break;
                case "double":  id = "D";  encontrado = true;
                                break;
            }
            
            list.agregar(new Identificador(token,token)); // warda el token sea cual sea
            
            if (encontrado) { // encontro una variable
                tipo = token;
                token = it.next();
                id += String.format("%3s", contadorTipo(tipo, list)).replace(" ", "0");
                list.agregar(new Identificador(id,token,tipo));
                encontrado = false;
            }

        }
        
        System.out.println(list);
    }
    
}
