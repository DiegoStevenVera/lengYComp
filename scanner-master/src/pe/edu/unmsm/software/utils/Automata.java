/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.unmsm.software.utils;

import java.util.Iterator;
import pe.edu.unmsm.software.scanner.Scanner;

/**
 *
 * @author USUARIO
 */
public class Automata {
    
    private Scanner obj = new Scanner();
    private final int qf=100;
    private final int qe=-1;
    private int q=0;
    private Pila<String> p = new Pila<>();
    
    public boolean reconoce(String cadena) {
        
        obj.setCadenaFuente(cadena); //asigna la cadena fuente
        String token; //obtiene el token
        
        while(q!=qf && q!= qe) {
            
            token=obj.analizar();
            
            switch(q) {
                case 0: if((token.equals("a") || token.equals("b")) && p.estaVacia()) {
                           q=1;
                           p.push("a"); //empila el simbolo a
                        }else{
                            if(token.equals("c") && p.estaVacia()) {
                                   q=1;
                                   p.push("c"); //empila el simbolo b  
                                }else {
                                    q=qe;
                                }
                        }
                break;
                
                case 1: if((token.equals("a") || token.equals("b")) && p.tamanno() > 0 && p.cima().equals("a")) {
                           q=1;
                           p.push("a"); //empila el simbolo a  
                        }else{
                           if(token.equals("c") && p.tamanno() > 0 && p.cima().equals("a")) {
                               q=1;
                               p.pop();
                           }else{
                               if((token.equals("a") || token.equals("b")) && p.tamanno() > 0 && p.cima().equals("c")) {
                                   q=1;
                                   p.pop();
                               }else{
                                  if(token.equals("c") && p.tamanno() > 0 && p.cima().equals("c")) {
                                      q=1;
                                      p.push("c");
                                  }else{
                                      if(token.equals("c") && p.estaVacia()) {
                                          q=1;
                                          p.push("c");
                                      }else{
                                          if(token.equals("a") || token.equals("b") && p.estaVacia()) {
                                              q=1;
                                              p.push("a");
                                          }else{
                                              if(token.equals("FIN") && p.estaVacia()) {
                                                  q=qf;
                                                  //sale
                                              }else{
                                                  q=qe;
                                              }
                                          }
                                      }
                                  }
                               }
                           }
                }
                break;
            }    
        }
        
        if(q==qf){
           return true; 
        }else{
            return false;
        }
    }
        
    
    
    public static void main(String [] args) {
        Automata a = new Automata();
        //c b b a c c $
        if(a.reconoce("c b a a c a c c c c")){
            System.out.println("es cadena");
        }else{
            System.out.println("no es cadena");
        }
    }
        
        
        
    }
