/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.software.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
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
    
    public static void crearArchivo(String texto, String nombreArchivo){
        URI uri = Paths.get(nombreArchivo).toUri();
        File file = new File(uri); 
        
        System.out.println("Archivo creado en: ");
        System.out.println(uri);
        System.out.println("");
        
        FileWriter fichero = null;
        PrintWriter pw = null;
        
        try
        {
            fichero = new FileWriter(file);
            pw = new PrintWriter(fichero);
            pw.append(texto);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {           
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
        
    }
    
    public static void borrarArchivo(String nombreArchivo){
        URI uri = Paths.get(nombreArchivo).toUri();
        File file = new File(uri);
        file.delete();
    }
    
    public Lista<String> getLista() {
        return lista;
    }
        
}
