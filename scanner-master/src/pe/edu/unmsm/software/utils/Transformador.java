/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.software.utils;

import java.util.Iterator;

/**
 *
 * @author bluq1
 */
public class Transformador {
    
    public static String transformar(){
        ControlarArchivo ca = new ControlarArchivo();
        
        Lista<String> listA = ca.getLista();
        
        Identificador actualID;
        boolean encontrado = false;
        
        ca.leerArchivo("lectura.txt");
        
        Iterator<String> itA = listA.iterator();        
        
        Lista<Identificador> lID = Analizador.analizar();
        
        StringBuilder builder = new StringBuilder();    // objeto mutable
        
        builder.append("");
        //System.out.println("");
        while (itA.hasNext()) {
            
            String token = itA.next();
            
            if (token.equals("FIN")) {
                builder.append("\n");
                //System.out.println("\n");
            } else {
                Iterator<Identificador> itID = lID.iterator();
                encontrado = false;
                while (itID.hasNext()) {
                    actualID = itID.next();
                    if (Identificador.COMPARADOR_NOMBRE.compare(actualID.getNombre(),token) == 0) {
                        builder.append(actualID.getId()).append(" ");
                        //System.out.print(actualID.getId() + " ");
                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    builder.append(token).append(" ");
                    //System.out.print(token + " ");
                }
                
            }
        }
        return builder.toString();
    }
}
