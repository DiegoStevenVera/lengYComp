/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.software.test;
import pe.edu.unmsm.software.utils.ControlarArchivo;
import pe.edu.unmsm.software.utils.Transformador;

/**
 *
 * @author diego
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        
        ControlarArchivo.crearArchivo("int i = 0;\n int j = 3;\n j++;", "lectura.txt");
        
        String datosDelNuevoArchivo = Transformador.transformar();
        
        ControlarArchivo.crearArchivo(datosDelNuevoArchivo, "nuevoArchivo.txt");
        
    }
    
}
