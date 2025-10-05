package domain.algoritmo;

import java.util.HashMap;
import java.util.Map;

public abstract class Algoritmo {

    protected HashMap<String,Integer> palabras;
    protected int ubicaciones;
    protected int sizeLayout;
    protected int mejorCosteActual;
    protected int nodos;

    protected int[][] flujo;
    protected int[][] distancias;
    protected char[][] layout;

    String alfabetoExtendido;

    // ==========================================================
    //           CONSTRUCTOR

    // ==========================================================

    /**
     * Constructor de algoritmo.
     */
    public Algoritmo(String alfabeto, HashMap<String,Integer> palabras) {
        this.palabras = palabras;

        int sizeAlfabeto=alfabeto.length();
        alfabetoExtendido = alfabeto;
        int raizUbicaciones = (int) Math.ceil(Math.sqrt(sizeAlfabeto));
        ubicaciones = raizUbicaciones*raizUbicaciones;
        sizeLayout = raizUbicaciones;
        layout = new char[raizUbicaciones][raizUbicaciones];

        // Si el tamañao del alfabeto es menor al de una matriz cuadrada
        // lo hacemos igual de grande.
        if (ubicaciones > sizeAlfabeto)
            for (int i = sizeAlfabeto; i < ubicaciones; i++) {
                alfabetoExtendido += ' ';
            }

        flujo = new int[ubicaciones][ubicaciones];
        distancias = new int[ubicaciones][ubicaciones];
        nodos=0;
        mejorCosteActual = Integer.MAX_VALUE;

        // Consigo la matriz de flujo apartir del alfabeto y la lista de palabras con frecuencia
        getFrecuencias();
        // Como sabemos que el tamaño es el layout (raizUbicaciones*raizUbicaciones) calculamos la
        // distancia entre cada ubicacion del mismo.
        getDistancias();

    }


    // ==========================================================
    //           FUNCIONES
    // ==========================================================

    /**
     * Crea la matriz de frecuencias a partir de la lista de palabras con frecuencias
     *
     */
    protected void getFrecuencias() {

        String palabra;
        int frecuencia;

        // Rellenamos la matriz de flujo con 0s.
        for (int i = 0; i < flujo.length; i++) {
            for (int j = 0; j < flujo.length; j++) {
                flujo[i][j]=0;
            }
        }

        // Calculamos la frecuencia de los pares de letras del alfabeto
        // entre las palabras de la lista de frecuencias
        for (Map.Entry<String, Integer> entrada : palabras.entrySet()) {
            palabra = entrada.getKey();
            frecuencia = entrada.getValue();

            for (int i = 0; i < palabra.length() - 1; i++) {
                char simbolo1 = palabra.charAt(i);
                char simbolo2 = palabra.charAt(i + 1);

                int indice1 = alfabetoExtendido.indexOf(simbolo1);
                int indice2 = alfabetoExtendido.indexOf(simbolo2);

                if (indice1 != -1 && indice2 != -1) {
                    flujo[indice1][indice2] += frecuencia;
                }
            }
        }
        // El resultado de la matriz anterior no es simetrica (ab != ba)
        // Para convertir la matriz de frencuencias en simetrica sumamos
        // su transpuesta.
        int[][] transpuesta = getMatrizTranspuesta(flujo);
        flujo = sumarMatrices(transpuesta, flujo);

    }

    /**
     * Crea la matriz de distancias a partir del tamaño del layout (sizeLayout)
     *
     */
    protected void getDistancias() {
        int size = alfabetoExtendido.length();
        int c = (int) Math.sqrt(ubicaciones);

        for (int i=0; i < size; ++i) {
            for (int j=0; j < size; ++j) {
                int x = i/c;
                int x2= j/c;
                int y = i%c;
                int y2 = j%c;
                distancias[i][j] = (int) (Math.sqrt( (x-x2)*(x-x2) + (y-y2)*(y-y2) )*10);
            }
        }
    }

    /**
     * Obtiene el coste de la solucion propuesta
     * @param solucion distribucion de teclado de la cual deseamos saber su coste
     * @return el coste de la solucion dada como parametro
     */
    protected int getCoste(int[] solucion) {
        int coste=0;
        for(int i=0; i < ubicaciones; ++i) {
            for(int j=0; j < ubicaciones; ++j) {
                if(solucion[i] != -1 && solucion[j] != -1)
                    coste += flujo[i][j]*distancias[solucion[i]][solucion[j]];
            }
        }
        return coste;
    }

    /**
     * Realiza la transpuesta de la matriz
     * @param matriz matriz de la cual deseamos obtener su transpuesta
     * @return devuelve la transpuesta de la matriz dada como parametro
     */
    protected int[][] getMatrizTranspuesta(int[][] matriz) {
        int filas = matriz.length;
        int columnas = matriz[0].length;
        int[][] transpuesta = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = matriz[i][j];
            }
        }

        return transpuesta;
    }

    /**
     * Realiza la suma de las matrices
     * @param matrizA primer termino de la suma
     * @param matrizB segundo termino de la suma
     * @return devuelve la suma de las matrices A y B
     */
    protected static int[][] sumarMatrices(int[][] matrizA, int[][] matrizB) {
        int filas = matrizA.length;
        int columnas = matrizA[0].length;
        int[][] matrizResultado = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizResultado[i][j] = matrizA[i][j] + matrizB[i][j];
            }
        }

        return matrizResultado;
    }


    /**
     * Pasa de la mejor asiganacion a su representacion real en matriz
     * @param result matriz de caracteres donde se almacenara la solucion
     */
    protected void toMatriz(char[][] result, int[] solucion) {
        int size=solucion.length;
        int c = result.length;

        for(int i=0; i < size; ++i) {
            int x, y;
            x = solucion[i] / c;
            y = solucion[i] % c;
            result[x][y] = alfabetoExtendido.charAt(i);
        }
    }


    /**
     * Devuelve la distribucion de teclado luego de haber aplicado el algoritmo correspondiente.
     *
     */
    public abstract char[][] getLayout();

}
