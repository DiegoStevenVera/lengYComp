/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

/**
 *
 * @author diego
 */
public class Scanner {

    public static Pila<String> scan(String palabra) {
        /**
         *  El metodo consiste en la cadena separarlo en un array y caracter 
         *  por caracter compararlo mediante ascii si es numero letra u otro 
         *  caracter especial dentro de un while, si el caracter es un numero 
         *  se activa la llave 'kNumero' y se pasa al siguiente caracter, la
         *  llave se activa para saber que fue el caracter anterior, si el 
         *  anterior fue un numero y el siguiente tambien un numero se agruparan
         *  dentro de un auxiliar, si se pasa de numero a letra u otro caracter
         *  se pushea dentro de una pila lo guardado en el auxiliar y luego se 
         *  inicia otra cadena
         */
        char p[] = palabra.toCharArray();
        int i = 0;
        boolean kLetra = false;
        boolean kCaracter = false;
        boolean kNumero = false;
        String aux = "";
        Pila<String> pila = new Pila<>();
        
        while (i < p.length) {
            
            if (p[i] != ' ') {
                if (p[i] >= 48 && p[i] <= 57) {
                    kNumero = true;
                    if (kLetra == true || kCaracter == true) { 
                        // si el anterior fue un caracter esecial o letra
                        pila.push(aux);
                        aux = "";
                        kLetra = false;
                        kCaracter = false;
                    }
                } else if (p[i] >= 65 && p[i] <= 90 || p[i] >= 97 && p[i] <= 122) {
                    kLetra = true;
                    if (kNumero == true || kCaracter == true) {
                        pila.push(aux);
                        aux = "";
                        kNumero = false;
                        kCaracter = false;
                    }
                } else {
                    kCaracter = true;
                    if (kNumero == true || kLetra == true) {
                        pila.push(aux);
                        aux = "";
                        kNumero = false;
                        kLetra = false;
                    } 
                }
                aux = aux + p[i];  
                
                if(p[i] == '(' || p[i] == ')' || p[i] == '{' || p[i] == '}' ||
                        p[i] == '[' || p[i] == ']') {
                    pila.push(String.valueOf(p[i]));
                    kCaracter = false;
                    aux = "";
                }
                
                switch(aux) {
                    case "++":
                    case "--":
                    case "+=":
                    case "-=":
                    case "int":
                    case "char":
                    case "string":
                    case "float":
                    case "boolean": pila.push(aux);
                                    kCaracter = false; 
                                    kLetra = false;
                                    aux = "";
                }
            }
            
            i++;
        }
        pila.push(aux);
        return pila;
    }
    
    public static void main(String[] args) {
        System.out.println(scan("int x = 2++;"));
    }
}
