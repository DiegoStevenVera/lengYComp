/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monticulomin;

/**
 *
 * @author diego
 */
public class MonticuloMin {

    public static void ordenar(Comparable[] cp) {
        int N = cp.length;
        for (int k = N/2; k >= 1; k--)
            hundir(cp, k, N);
        while (N > 1) {
            intercambiar(cp, 1, N--);
            hundir(cp, 1, N);
        }
    }

    private static void hundir(Comparable[] pq, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && mayorQue(pq, j, j+1)) j++;
            if (!mayorQue(pq, k, j)) break;
            intercambiar(pq, k, j);
            k = j;
        }
    }

    private static boolean mayorQue(Comparable[] cp, int i, int j) {
        return cp[i-1].compareTo(cp[j-1]) > 0;
    }

    private static void intercambiar(Object[] cp, int i, int j) {
        Object aux = cp[i-1];
        cp[i-1] = cp[j-1];
        cp[j-1] = aux;
    }

    private static boolean mayorQue(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }
        

    private static boolean estaOrdenado(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (mayorQue(a[i], a[i-1])) return false;
        return true;
    }

    private static void mostrar(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String monticuloMin[] = {"hola", "abecedario", "pollo", "carro", "perro"};
        
        ordenar(monticuloMin);
        mostrar(monticuloMin);
    }


}
