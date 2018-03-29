/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.software.scanner;

/**
 *
 * @author bluq1
 */
public class Scanner {
    
    private String cadenaFuente;
    private int posicion;

    public Scanner() {
        this.cadenaFuente = "";
        this.posicion = 0;
    }
    
    public String analizar(){
        
        if(posicion != cadenaFuente.length()){
            
            String cadenaResultante = "";
            
            while(cadenaFuente.substring(posicion ,posicion + 1).equals(" ")){
                posicion++;
            }        

            char caracter = cadenaFuente.charAt(posicion);

            if((caracter >= 'A' && caracter <= 'Z') || (caracter >= 'a' && caracter <= 'z')){
                while ((caracter >= 'A' && caracter <= 'Z') || 
                       (caracter >= 'a' && caracter <= 'z') || 
                       (caracter >= '0' && caracter <= '9')) {
                    cadenaResultante = cadenaResultante + caracter;
                    posicion++;
                    if(posicion < cadenaFuente.length()) caracter = cadenaFuente.charAt(posicion);
                    else break;
                }
            } else if (caracter >= '0' && caracter <= '9'){
                while (caracter >= '0' && caracter <= '9') {                
                    cadenaResultante = cadenaResultante + caracter;
                    posicion++;
                    if(posicion < cadenaFuente.length()) caracter = cadenaFuente.charAt(posicion);
                    else break;               
                }
            } else if (caracter == '/' && cadenaFuente.charAt(posicion + 1)=='/'){
                posicion = cadenaFuente.length();
                cadenaResultante = "FIN";
            } else if (caracter==',' || caracter=='(' || caracter==')' || caracter=='=' || 
                       caracter=='*' || caracter=='/' || caracter=='-' || caracter=='+' || 
                       caracter=='<' || caracter=='>' || caracter==';' || caracter=='[' || 
                       caracter==']' || caracter=='{' || caracter=='}' || caracter=='.' ||
                       caracter=='&' || caracter=='|' || caracter=='!') {              
                cadenaResultante = "" + caracter;   
                if ((caracter=='-' && cadenaFuente.charAt(posicion + 1)=='-') ||
                    (caracter=='+' && cadenaFuente.charAt(posicion + 1)=='+') ||
                    (caracter=='<' && cadenaFuente.charAt(posicion + 1)=='=') ||
                    (caracter=='>' && cadenaFuente.charAt(posicion + 1)=='=') ||
                    (caracter=='=' && cadenaFuente.charAt(posicion + 1)=='=') ||
                    (caracter=='&' && cadenaFuente.charAt(posicion + 1)=='&') ||
                    (caracter=='|' && cadenaFuente.charAt(posicion + 1)=='|') ||
                    (caracter=='!' && cadenaFuente.charAt(posicion + 1)=='=')){
                    cadenaResultante = cadenaResultante + cadenaFuente.charAt(posicion + 1);
                    posicion++;
                }
                posicion++;
            } else if (caracter == 34) { // ""
                cadenaResultante += caracter;
                posicion++;
                while (posicion < cadenaFuente.length() && cadenaFuente.charAt(posicion) != 34) {
                    cadenaResultante += cadenaFuente.charAt(posicion);
                    posicion++;
                }
                cadenaResultante += cadenaFuente.charAt(posicion);
                posicion++;
            } else if (caracter == 39) { // ''
                cadenaResultante += caracter;
                posicion++;
                while (posicion < cadenaFuente.length() && cadenaFuente.charAt(posicion) != 39) {
                    cadenaResultante += cadenaFuente.charAt(posicion);
                    posicion++;
                }
                cadenaResultante += cadenaFuente.charAt(posicion);
                posicion++;
            }
            return cadenaResultante;    
        } else {
            return "FIN";
        }        
        
    }

    public int getPosicion() {
        return posicion;
    }

    public void setCadenaFuente(String cadenaFuente) {
        this.cadenaFuente = cadenaFuente;
    }
    
}
