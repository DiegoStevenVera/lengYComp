/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.software.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.nio.file.Paths;
import java.util.Scanner;
/**
 *
 * @author bluq1
 */
public class ControlarArchivo {
    
    private Lista<String> lista;

    public ControlarArchivo() {
        lista = new Lista<>();
    }
        
    public void leerArchivo(String nombre){        
        URI uri = Paths.get(nombre).toUri();
        File file = new File(uri);
        
        try {
            Scanner scanner = new Scanner(file);            
            while (scanner.hasNextLine()) {
                pe.edu.unmsm.software.scanner.Scanner scan = new pe.edu.unmsm.software.scanner.Scanner();
                scan.setCadenaFuente(scanner.nextLine());
                String token = "";
                
                while(!token.equals("FIN")){
                    token = scan.analizar();
                    lista.agregar(token);
                }
            }
            scanner.close();
        } 
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Lista<String> getLista() {
        return lista;
    }
        
}
