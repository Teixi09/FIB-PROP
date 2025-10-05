package domain.algoritmo;

import java.util.*;

public class QAP extends Algoritmo {

    // ==========================================================
    //           ATRIBUTOS
    // ==========================================================

    int[] mejorSolucionActual;

    // ==========================================================
    //           CONSTRUCTOR
    // ==========================================================

    /**
     * Constructor de QAP.
     *
     * @param alfabeto alfabeto con el que se creara el teclado
     * @param palabras conjunto de palabras con el qeu se creará el teclado
     */
    public QAP(String alfabeto, HashMap<String,Integer> palabras) {
        super(alfabeto, palabras);

        // Generamos una solucion inicial aleatoria
        getSolucionInical();
        // Inicilizamos parametros y emepezamos la exploracion del espacio de busqueda
        resolver();
        // Convertirmo la mejor solucion a una matriz de caracteres, es decir, el layout
        super.toMatriz(layout, mejorSolucionActual);
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
     * Genera una solucion actual con un coste relativamente bueno para emepzar a podar cuanto antes en la busqeuda
     */
    private void getSolucionInical() {
        mejorSolucionActual = new int[ubicaciones];
        int[] sol = new int[ubicaciones];

        for (int i = 0; i < ubicaciones; i++) {
            sol[i] = i;
        }

        for (int j=0; j < 1000000; ++j) {
            // Convierte el arreglo de int en una lista de objetos Integer
            Integer[] arregloInteger = Arrays.stream(sol).boxed().toArray(Integer[]::new);
            List<Integer> lista = Arrays.asList(arregloInteger);

            // Baraja (shuffle) la lista
            Collections.shuffle(lista);

            // Convierte la lista nuevamente en un arreglo de int
            arregloInteger = lista.toArray(new Integer[0]);
            sol = Arrays.stream(arregloInteger).mapToInt(Integer::intValue).toArray();
            int actual=super.getCoste(sol);
            if (actual < mejorCosteActual) {
                mejorCosteActual = actual;
                System.arraycopy(sol, 0, mejorSolucionActual, 0, mejorSolucionActual.length);
            }
        }

    }

    /**
     * Inicializa ciertos arrays para empezar a crear la soluciones con el algoritmo de branch&bound
     */
    private void resolver() {

        int[] solucionActual = new int[ubicaciones];
        boolean[] yaEnSolucion = new boolean[ubicaciones];

        for (int i = 0; i < ubicaciones; i++) {
            yaEnSolucion[i]=false;
        }
        exploracion(0,0,solucionActual, yaEnSolucion);
    }

    /**
     * Genera todas las soluciones al problema y poda las solaciones sin potencial usando la cota Gilmore-Lawrence
     * Es el algoritmo de branch&bound
     *
     * @param costeActual el coste de la solucion actual y el valor que se intenta minimizar
     * @param sizeSolucionActual cantidad de asignaciones colocadas
     * @param solucionActual array que representa la solucion actual
     * @param yaEnSolucion posiciones que ya fueron asignadas
     */
    private void exploracion(int costeActual, int sizeSolucionActual, int[] solucionActual, boolean[] yaEnSolucion) {
        ++nodos;

        if (sizeSolucionActual == ubicaciones) {
            if (costeActual < mejorCosteActual) {

                mejorCosteActual = costeActual;
                System.arraycopy(solucionActual, 0, mejorSolucionActual, 0, mejorSolucionActual.length);
            }
        }
        else if (sizeSolucionActual == 0) {
            boolean[] evitarPermutacion = new boolean[ubicaciones];

            Arrays.fill(evitarPermutacion,false);
            Arrays.fill(solucionActual,-1);

            for (int i = 0; i < ubicaciones; i++) {
                evitarPermutaciones(i, evitarPermutacion);
                if(!evitarPermutacion[i]) {
                    solucionActual[0] = i;
                    yaEnSolucion[i]=true;
                    exploracion(0, 1, solucionActual, yaEnSolucion);
                    yaEnSolucion[i] = false;
                }
            }
        }
        else {
            int cotaInferior=0;

            int ubicacionesFaltantantes = ubicaciones - sizeSolucionActual;
            int[][] c1  = new int[ubicacionesFaltantantes][ubicacionesFaltantantes];

            ArrayList<Map.Entry<Integer,Integer>> incrementosCoste = new ArrayList<>();

            for (int k=sizeSolucionActual; k  < ubicaciones; ++k) {
                for (Integer i = 0, indiceFila = 0; i < ubicaciones; i++) {
                    if (!yaEnSolucion[i]) {
                        Integer incrementoCoste = 0;
                        for (int j = 0; j < sizeSolucionActual; j++) {
                            incrementoCoste += 2 * distancias[solucionActual[j]][i] * flujo[j][k];
                        }
                        if (k == sizeSolucionActual)
                            incrementosCoste.add(new AbstractMap.SimpleEntry<>(i, incrementoCoste) );
                        int fila = k-sizeSolucionActual;
                        c1[fila][indiceFila] = incrementoCoste;
                        ++indiceFila;
                    }
                }
            }

            incrementosCoste.sort(Map.Entry.comparingByValue());

            if(sizeSolucionActual < ubicaciones-1)
                cotaInferior = cotaInferiorParaSolucionParcial(sizeSolucionActual, yaEnSolucion, c1);

            if (costeActual+cotaInferior >= mejorCosteActual) return;


            for (Map.Entry<Integer, Integer> e : incrementosCoste) {
                solucionActual[sizeSolucionActual] = e.getKey();
                yaEnSolucion[e.getKey()] = true;
                exploracion(costeActual+e.getValue(), sizeSolucionActual+1, solucionActual, yaEnSolucion);
                if (costeActual+cotaInferior >= mejorCosteActual) return;
                solucionActual[sizeSolucionActual] = -1;
                yaEnSolucion[e.getKey()] = false;
            }

        }
    }

    /**
     * Calcula la cota inferior para podar soluciones parciales cuanto antes
     *
     * @param sizeSolucionParcial cantidad de asignaciones colocadas en la solución parcial
     * @param yaEnSolucion posiciones que ya fueron asignadas
     * @param c1 matriz que representa el coste de asignar cada letra en cada una de las posiciones todavía disponibles
     */
    private int cotaInferiorParaSolucionParcial(int sizeSolucionParcial, boolean[] yaEnSolucion, int[][] c1) {
        int ubicacionesFaltantes = ubicaciones - sizeSolucionParcial;
        int[][] nuevoFlujo = new int[ubicacionesFaltantes][ubicacionesFaltantes];
        int[][] nuevoDistancia = new int[ubicacionesFaltantes][ubicacionesFaltantes];

        for (int i = sizeSolucionParcial,indiceFila=0; i < ubicaciones; i++) {
            for (int j = sizeSolucionParcial, indiceColumna=0; j < ubicaciones; j++) {
                nuevoFlujo[indiceFila][indiceColumna++] = flujo[i][j];
            }
            Arrays.sort(nuevoFlujo[i - sizeSolucionParcial]);
            ++indiceFila;
        }


        for (int i = 0, indiceFila=0; i < ubicaciones; i++) {
            if (yaEnSolucion[i])
                continue;

            for (int j = 0,indiceColumna = 0; j < ubicaciones; j++) {
                if (yaEnSolucion[j])
                    continue;
                nuevoDistancia[indiceFila][indiceColumna] = distancias[i][j];
                indiceColumna++;
            }

            Integer[] subarray = Arrays.stream(nuevoDistancia[indiceFila]).boxed().toArray(Integer[]::new);
            Arrays.sort(subarray, 0, ubicacionesFaltantes, Collections.reverseOrder());
            nuevoDistancia[indiceFila] = Arrays.stream(subarray).mapToInt(Integer::intValue).toArray();
            indiceFila++;
        }

        int[][] c2 = new int[ubicacionesFaltantes][ubicacionesFaltantes];

        for(int i = 0; i < ubicacionesFaltantes; ++i)
            for(int j = 0; j < ubicacionesFaltantes; ++j)
                for(int k = 0; k < ubicacionesFaltantes-1; ++k)
                    c2[i][j] += nuevoDistancia[j][k]*nuevoFlujo[i][k];

        int[][] c1c2 = new int[ubicacionesFaltantes][ubicacionesFaltantes];

        // Copiar los elementos de la matriz original a la nueva matriz
        for (int i = 0; i < ubicacionesFaltantes; i++) {
            for (int j = 0; j < ubicacionesFaltantes; j++) {
                c1c2[i][j] = c1[i][j]+ c2[i][j];
            }
        }

        Hungarian h = new Hungarian(c1c2);

        int lap = h.getTotal();

        return lap;
    }

    /**
     * Evita ciertas permutaciones para evitar un gran parte del espacio de búsqueda, en específico aquellas que se
     * podrían ver como una rotación de la matriz en 90 180 y 270 grados
     *
     * @param indice posición en la que fue colocada la primera letra, para ver donde se encontraran luego de aplicar
     *               las rotaciones
     * @param evitarPermutaciones posiciones que ya fueron asignadas
     */
    private void evitarPermutaciones(int indice, boolean[] evitarPermutaciones) {
        //Convierto las coordenadas de vector a matriz
        int i = indice/sizeLayout;
        int j = indice%sizeLayout;
        for (int k=0; k < 3; ++k) {
            // Nueva posicion luego de aplicar rotacion de 90 grados
            int ni = j, nj = sizeLayout-1-i;
            // La guardamos para volver aplicar otros 90 grados hasta dar una vuelta
            i = ni;
            j = nj;
            // Pasamos de coordenadas de matriz a vector
            int nindice = ni * sizeLayout + nj;
            evitarPermutaciones[nindice] = true;
        }

    }

}
