package javaapplication1;

/**
 *
 * @author Antonio
 * He utilizado el algoritmo de la criba de Eratostenes
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here               

        boolean[] tablaEratostenes = initTablaEratostenes(300);
           
        tablaEratostenes = cribarTabla(tablaEratostenes);

        mostrarTabla(tablaEratostenes, tablaEratostenes.length / 10);
        
        int[] primos = getPrimos(50, tablaEratostenes);
       
        mostrarPrimos(primos, tablaEratostenes);
        
        mostrarSumaPrimos(primos, tablaEratostenes);
    }

    public static void mostrarPrimos(int[] primos, boolean[] tablaEratostenes) {
                
        System.out.println();
        for (int i = 0; i < primos.length; i++) {
            System.out.println((i + 1) + ": " + primos[i] + ", ");
        }
    }
    
    public static void mostrarSumaPrimos(int[] primos, boolean[] tablaEratostenes) {
                
        System.out.println();
        int suma = 0;
        for (int i = 0; i < primos.length; i++) {
            suma += primos[i];            
        }
        
        System.out.println("Suma de los primeros 50 números primos: " + suma);
    }
    
    public static void mostrarTabla(boolean[] tabla, int filasMostradas) {
     
         final String ANSI_RED_BACKGROUND = "\u001B[41m";
        final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
        
        int num = 0;
        for (int i = 0; i < filasMostradas; i++) {
            for (int j = 0; j < 10; j++) {
                num = j + 1 + (i * 10);
                if (tabla[num - 1]) {
                    System.out.print(ANSI_RED_BACKGROUND + num + " ");
                } else {
                    System.out.print(ANSI_GREEN_BACKGROUND + num + " ");
                }
            }
            System.out.println();
        }
    }
    public static boolean[] cribarTabla(boolean[] tabla) {

        int sizeTable = tabla.length;
        boolean cribaTerminada = false;

        tabla[0] = true;

        int candidatoPrimo = 2;
        int j = 0;
        int i = 1;
        while (i < sizeTable && !cribaTerminada) {
            j = i;
            candidatoPrimo = i + 1;
            int multiploCandidato = candidatoPrimo * (j + 1);
            if (multiploCandidato >= sizeTable) {
                cribaTerminada = true;
            } else {
                while (j < sizeTable - 1 && !cribaTerminada && multiploCandidato < sizeTable) {                                        
                    tabla[multiploCandidato - 1] = true;
                    
                    j++;
                    multiploCandidato = candidatoPrimo * (j + 1);                    
                }
            }
            i++;
        }
        return tabla;
    }

    public static int[] getPrimos(int numPrimos, boolean[] tabla) {

        int sizeTable = tabla.length;
        int[] primos = new int[numPrimos];

        int p = 0;
        int i = 0;
        int primosEncontrados = 0;
        while (i < sizeTable && primosEncontrados < numPrimos) {
            if (!tabla[i]) {
                primos[p] = i + 1;
                primosEncontrados++;

                p++;
            }
            i++;
        }
        return primos;
    }

    public static boolean[] initTablaEratostenes(int size) {
        
        boolean[] tabla = new boolean[size];        
                
        for (int i = 0; i < size; i++) {
            tabla[i] = false;
        }
        
        return tabla;
    }
}