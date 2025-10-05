package domain.algoritmo;

import java.util.*;
import java.util.stream.Collectors;

public class ALG2 extends Algoritmo {

    // ==========================================================
    //           ATRIBUTOS
    // ==========================================================

    private int[] solucion;

    private double temp = 1000;
    private double ratioEnfriamiento = 0.05;
    private int iteracion = 1000;

    // ==========================================================
    //           CONSTRUCTOR
    // ==========================================================

    /**
     * Constructor de ALG2.
     */
    public ALG2(String alfabeto, HashMap<String,Integer> palabras) {
        super(alfabeto, palabras);

        // Generamos una solucion inicial aleatoria
        getSolucionInical();

        // Inicilizamos parametros y emepezamos la exploracion del espacio de busqueda
        resolver( Arrays.stream(solucion).boxed().collect(Collectors.toList()) );
        // Convertirmo la mejor solucion a una matriz de caracteres, es decir, el layout
        super.toMatriz(layout, solucion);
    }

    // ==========================================================
    //           FUNCIONES
    // ==========================================================

    /**
     * Devuelve la distribucion de teclado luego de haber aplicado el algoritmo correspondiente.
     *
     */
    @Override
    public char[][] getLayout() {
        return layout;
    }

    /**
     * Generamos una solucion inicial para establecer un coste minimo como base, para que el algoritmo avance.
     */
    private void getSolucionInical() {

        int size = distancias.length;

        // Creamos dos arrays, con la cantidad de filas que poseen las matrices de flujo y distancia.
        int[] sumaFlujos = new int[size];
        int[] sumaDistancias = new int[size];

        //Creamos una array que contendrá la solución inicial
        solucion = new int[size];

        // Vamos colocando en el array, la suma total de cada fila de la matriz de flujo
        for (int i = 0; i < size; i++) {
            int aux = 0;
            for (int j = 0; j < size; j++) {
                aux += flujo[i][j];
            }
            sumaFlujos[i] = aux;
        }

        // Vamos colocando en el array, la suma total de cada fila de la matriz de distancias
        for (int i = 0; i < size; i++) {
            int aux = 0;
            for (int j = 0; j < size; j++) {
                aux += distancias[i][j];
            }
            sumaDistancias[i] = aux;
        }

        // Aquí creamos una solución inicial con un minimo de criterio, que es el siguiente:
        // Buscamos la posicion que tiene la menor distancia con el resto y le asignamos la tecla que posee el mayor flujo.
        // Eliminamos las mejores posciones obtenidas anteriormente y repetimos el anterior paso hasta completar la solucion.
        // Esto no conseguirá una solucion muy buena, ya que el criterio anterior no necesariamente significa que se agrupen
        // las teclas de buena manera, pero por el hecho de ir colocando las teclas de mayor flujo en las mejores posciones
        // masomenos asegura que algunas coincidan.
        for (int i = 0; i < size; i++) {
            //Aquí es donde colocamos la posicion que tiene la menor distancia con el resto y le asignamos la tecla que posee el mayor flujo.
            solucion[Math.abs(getMinIndex(sumaDistancias))] = getMaxIndex(sumaFlujos);
            //Aquí descartamos las mejores posiciones
            sumaDistancias[Math.abs(getMinIndex(sumaDistancias))] = 10000000;
            sumaFlujos[Math.abs(getMaxIndex(sumaFlujos))] = -1;
        }
    }

    /**
     * Devuelve el índice del elemento con el maximo valor
     * @param array el array del cual devolverá el índice del elemento con el maximo valor
     * @return devuelve el índice del elemento con el maximo valor, o -1 en caso de que el array este vació.
     */
    private static int getMaxIndex(int[] array){
        if ( array == null || array.length == 0 ) return -1;

        int max = 0;
        for ( int i = 1; i < array.length; i++ ) {
            if ( array[i] > array[max] ) max = i;
        }
        return max;
    }

    /**
     * Devuelve el índice del elemento con el menor valor
     * @param array el array del cual devolverá el índice del elemento con el menor valor
     * @return devuelve el índice del elemento con el menor valor, o -1 en caso de que el array este vació.
     */
    private static int getMinIndex(int[] array){
        if ( array == null || array.length == 0 ) return -1;

        int index = 0;
        int min = array[index];

        for (int i = 1; i < array.length; i++) {
            if (array[i] <= min){
                min = array[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * Funcion que aplica el algoritmo de Simulated Annealing(SA).
     * @param solucionActual lista que representa solucion del SA, se tiene que dar una solucion inicial valida.
     */
    private void resolver(List<Integer> solucionActual) {
        // Establecemos el litmite de tiempo del algoritmo de SA
        while (temp > 0.05) {
            // Cantidad de iteraciones por paso
            for(int i = 0 ; i < iteracion ; i++) {

                // Creamos una nueva lista para guardar la nueva solucion
                List<Integer> nuevaSolucion = new ArrayList<Integer>(solucionActual);

                // Instanciamos una clase random.
                Random rand = new Random();

                // Obtenemos dos posiciones posibles aleatorias.
                int pos1 = rand.nextInt(solucionActual.size());
                int pos2 = rand.nextInt(solucionActual.size());

                // En caso de haber obtenido la misma, buscamos una nueva posicion hasta que sean distintas
                while (pos1 == pos2) {
                    pos2 = rand.nextInt(solucionActual.size());
                }

                // Almacenamos los valores de las posiciones aleatorias obtenidas anteriormente
                int swap1 = nuevaSolucion.get(pos1);
                int swap2 = nuevaSolucion.get(pos2);

                // Intercambiamos los valores de las posicones, nuestro unico operador.
                nuevaSolucion.set(pos2, swap1);
                nuevaSolucion.set(pos1, swap2);

                // Convertimos la solucionActual en un array
                int[] csol = new int[solucionActual.size()];
                for (int j = 0; j < solucionActual.size(); j++) {
                    csol[j] = solucionActual.get(j);
                }

                // Convertimos la nuevaSolucion en un array
                int[] nsol = new int[nuevaSolucion.size()];
                for (int j = 0; j < nuevaSolucion.size(); j++) {
                    nsol[j] = nuevaSolucion.get(j);
                }

                // Obtenemos los costes de la soluciones
                int costeActual = super.getCoste(csol);
                int costeVecino = super.getCoste(nsol);

                // Obtenemos un número aleatorio para usarlo en la etapa de aceptación
                double random = rand.nextDouble();

                // Decidimos si debemos aceptar esta solucion.
                if ((probabilidadAceptar(costeActual, costeVecino, temp) > random))
                    solucionActual = nuevaSolucion;

            }

            // Enfriamos el sistema
            temp = temp * (1 - ratioEnfriamiento);
        }

        // Actualizamos la solución global.
        for (int j = 0; j < solucion.length; j++)
            solucion[j] = solucionActual.get(j);

    }

    /**
     * Funcion que nos devuelve la probabilidad de aceptar la nueva solucion obtenida.
     *
     * @param costeActual coste de la solucion actual.
     * @param costeVecino coste de la nueva solucion.
     * @param temperatura temperatura en la que se encutnra el sistema.
     *
     * @return En caso de que el coste de la nueva solucion sea mejor a la actual, la probabiliad será del 100%
     *          y devolvermos 1.0, en caso contrario tenemos en cuenta la diferencia entre soluciones y temperatura
     *          cuanto menor sea la diferenica de coste y/o cuanto mayor sea la temperatura, mayor probabilidad
     */
    private double probabilidadAceptar(int costeActual, int costeVecino, double temperatura) {
        if (costeVecino < costeActual)
            return 1.0;

        return Math.exp((costeActual - costeVecino) / temperatura);
    }

}
