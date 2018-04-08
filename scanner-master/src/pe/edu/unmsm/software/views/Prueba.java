/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.software.views;
import java.util.Iterator;
import pe.edu.unmsm.software.utils.Analizador;
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
        
        ControlarArchivo ca = new ControlarArchivo();
        Lista<String> listA = new Lista();
        Lista<Identificador> lID = new Lista();
        Iterator<String> itA;
        Iterator<Identificador> itID;
        String token;
        Identificador actualID;
        boolean encontrado = false;
        
        ca.leerArchivo("lectura.txt");
        listA = ca.getLista();
        itA = listA.iterator();
        
        lID = Analizador.analizar();
        System.out.println("");
        while (itA.hasNext()) {
            token = itA.next();
            
            if (token == "FIN") {
                System.out.println("\n");
            } else {
                itID = lID.iterator();
                encontrado = false;
                while (itID.hasNext()) {
                    actualID = itID.next();
                    if (Identificador.COMPARADOR_NOMBRE.compare(actualID.getNombre(),token) == 0) {
                        System.out.print(actualID.getId() + " ");
                        encontrado = true;
                    }
                }

                if (!encontrado) {
                    System.out.print(token + " ");
                }
            }
        }
    }
    
}
