/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.software.views;
import java.util.Comparator;
import java.util.Iterator;
import pe.edu.unmsm.software.scanner.Scanner;
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
    
    public static void main(String[] args) {
        String cadenarepuesto = "";
        String token = "";
        String tipo = "";
        String id = "";
        Lista<Identificador> list = new Lista<>();
        Lista<String> archivo;
        ControlarArchivo ca = new ControlarArchivo();
        Iterator<String> it;
        
        int nInt = 0, nString = 0, nChar = 0, nFloat = 0, nDouble = 0;
        int n = 0;
        
        ca.leerArchivo();
        archivo = ca.getLista();
        it = archivo.iterator();
        
        while (it.hasNext()) {
            token = it.next();
            
            switch (token) {
                case "int":     id = "I"; nInt++; 
                                n = nInt; break;
                case "String":  id = "S"; nString++; 
                                n = nString; break;
                case "char":    id = "C"; nChar++; 
                                n = nChar; break;
                case "float":   id = "F"; nFloat++; 
                                n = nFloat; break;
                case "double":  id = "D"; nDouble++; 
                                n = nDouble; break;
            }
            
            list.agregar(new Identificador(token,token)); // warda el token sea cual sea
            
            if (n != 0) { // encontro una variable
                tipo = token;
                token = it.next();
                id += String.format("%3s", n).replace(" ", "0");
                list.agregar(new Identificador(id,token,tipo));
                n = 0;
            }

        }
        
        System.out.println(list);
    }
    
}
