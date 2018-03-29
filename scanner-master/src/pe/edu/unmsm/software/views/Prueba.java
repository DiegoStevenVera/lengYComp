/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.software.views;
import pe.edu.unmsm.software.scanner.Scanner;
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
        String id = "";
        Scanner sc;
        Lista<Identificador> list = new Lista<>();
        
        int nInt = 0, nString = 0, nChar = 0, nFloat = 0, nDouble = 0;
        int n = 0;
        
        while (true) { // archivo leyendo linea por linea
            sc = new Scanner();
            // cadenarepuesto jala una linea del archivo
            while (token != "FIN") {
                
                sc.setCadenaFuente(cadenarepuesto);
                token = sc.analizar();
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
                
                if (n != 0) {
                    id += "00" + n;
                    token = sc.analizar();
                    list.agregar(new Identificador(id,token));
                    n = 0;
                }
                
            }
        }
    }
    
}
