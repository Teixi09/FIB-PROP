package domain.algoritmo;


public class Hungarian {
    int[] filas;
    int[] columnasOcupadas;
    private int[][] matrizOriginal;
    private int[][] valores;
    private int[][] lineas;
    private int numLineas;

    public Hungarian(int[][] matrix) {
        // Inicializamos
        matrizOriginal = matrix;
        valores = cloneMatrix(matrix); // Copiamos la matriz original
        filas = new int[valores.length];
        columnasOcupadas = new int[valores.length];

        //Algorithm
        // Paso 1
        restarFilaMinima();
        // Paso 2
        restarColumnaMinima();
        // Paso 3
        cubrirCeros();
        while (numLineas < valores.length) {
            // Paso 4
            crearCerosAdicionales();
            // Paso 3 Otra vez
            cubrirCeros();
        }
        // Optimizacion
        optimization();
    }

    /**
     * Restamos por cada elemento el minimo valor de su fila
     */
    private void restarFilaMinima() {
        int[] rowMinValue = new int[valores.length];
        // gurdamos el minimo de cada fila en rowMinValue[]
        for (int row = 0; row < valores.length; row++) {
            rowMinValue[row] = valores[row][0];
            for (int col = 1; col < valores.length; col++) {
                if (valores[row][col] < rowMinValue[row])
                    rowMinValue[row] = valores[row][col];
            }
        }

        //restamos el minimo de cada fila usando rowMinValue[]
        for (int row = 0; row < valores.length; row++) {
            for (int col = 0; col < valores.length; col++) {
                valores[row][col] -= rowMinValue[row];
            }
        }
    }

    /**
     * Restamos por cada elemento el minimo valor de su columna
     */
    private void restarColumnaMinima() {
        int colMinValue[] = new int[valores.length];
        // gurdamos el minimo de cada fila en colMinValue[]
        for (int col = 0; col < valores.length; col++) {
            colMinValue[col] = valores[0][col];
            for (int row = 1; row < valores.length; row++) {
                if (valores[row][col] < colMinValue[col])
                    colMinValue[col] = valores[row][col];
            }
        }

        //restamos el minimo de cada columna usando colMinValue[]
        for (int col = 0; col < valores.length; col++) {
            for (int row = 0; row < valores.length; row++) {
                valores[row][col] -= colMinValue[col];
            }
        }
    }

    /**
     * Recorremos todos los elementos y llamamos a la funcion pintarVecino cuando un elemento es igual a zero
     */
    private void cubrirCeros() {
        numLineas = 0;
        lineas = new int[valores.length][valores.length];

        for (int row = 0; row < valores.length; row++) {
            for (int col = 0; col < valores.length; col++) {
                if (valores[row][col] == 0)
                    pintarVecino(row, col, maxVH(row, col));
            }
        }
    }

    /**
     *
     * Nos fijamos que direccion (vertical, horizontal) contiene ceros, y cada vez que encontramos un cero verticalmente
     * incrementamos el resultado y cada vez que encontramos un cero horizontalmente, decrementamos el resultado. Al final
     * el resultado terminara siendo negativo, cero o positivo.
     *
     * @param  fila fila indice para la casilla objetivo
     * @param  columna columna indice para la casilla objetivo
     * @return positivo significa que la linea que pasa por indices [fila][columna] debe ser vertical
     *         zero o negativo significa que la linea que pasa por los indicies [fila][columna] debe ser horizontal*/
    private int maxVH(int fila, int columna) {
        int result = 0;
        for (int i = 0; i < valores.length; i++) {
            if (valores[i][columna] == 0)
                result++;
            if (valores[fila][i] == 0)
                result--;
        }
        return result;
    }

    /**
     * Pinta los vecinos de la celda de indice [fila][columna]. Para saber en que direccion hay que dibujar la linea, le damos el valor maxVH
     *
     * @param fila  Indice de la fila para la celda objetivo
     * @param col   Indice de la columna para la celda objetivo
     * @param maxVH valor devuelto por la funcion maxVH
     *              positivo significa que la linea a dibujar pasa por los indicies [fila][col] es vertical
     *              negativo o cero significa que la linea a dibujar pasa por los indices [fila][col] es horizontal
     */
    private void pintarVecino(int fila, int col, int maxVH) {
        if (lineas[fila][col] == 2)
            return;

        if (maxVH > 0 && lineas[fila][col] == 1)
            return;

        if (maxVH <= 0 && lineas[fila][col] == -1)
            return;

        for (int i = 0; i < valores.length; i++) {
            if (maxVH > 0) {
                if (lineas[i][col] == -1 || lineas[i][col] == 2) {
                    lineas[i][col] = 2;
                } else {
                    lineas[i][col] = 1;
                }
            } else {
                if (lineas[fila][i] == 1 || lineas[fila][i] == 2) {
                    lineas[fila][i] = 2;
                } else {
                    lineas[fila][i] = -1;
                }
            }
        }
        numLineas++;
    }

    /**
     * Este paso no siempre se ejecuta. Fijarse en la construccion
     * Crea ceros adicionales, pintando el minimo valor de celdas no cubiertas
     */
    private void crearCerosAdicionales() {
        int minUncoveredValue = 0;

        // Encontrar el minimo en los numeros no curbiertos
        for (int row = 0; row < valores.length; row++) {
            for (int col = 0; col < valores.length; col++) {
                if (lineas[row][col] == 0 && (valores[row][col] < minUncoveredValue || minUncoveredValue == 0))
                    minUncoveredValue = valores[row][col];
            }
        }

        // Restarle el minimo a todos los elementos no cubiertos, y añadirlo a todos los elementos cubiertos dos veces
        for (int row = 0; row < valores.length; row++) {
            for (int col = 0; col < valores.length; col++) {
                if (lineas[row][col] == 0)
                    valores[row][col] -= minUncoveredValue;

                else if (lineas[row][col] == 2)
                    valores[row][col] += minUncoveredValue;
            }
        }
    }

    /**
     * Optimizaacion, asigna a cada fila una celda a una columna unica. Como una fila puede contener mas de 1 cero
     * necesitamos asegurarnos que todas las filas esten asignadas a una celda de la columna unica.
     * Para hacerlo usamos fuerza bruta
     *
     * @param fila
     * @return true
     **/
    private boolean optimization(int fila) {
        if (fila == filas.length)
            return true;

        for (int col = 0; col < valores.length; col++) {
            if (valores[fila][col] == 0 && columnasOcupadas[col] == 0) {
                filas[fila] = col;
                columnasOcupadas[col] = 1;
                if (optimization(fila + 1))
                    return true;
                columnasOcupadas[col] = 0;
            }
        }
        return false;
    }

    /**
     * Overload optimization(int row) method
     */
    private void optimization() {
        optimization(0);
    }

    /**
     * Devuelve la suma del coste de la mejor asignacion
     *
     * @return Total values
     */
    public int getTotal() {
        int total = 0;
        for (int row = 0; row < valores.length; row++)
            total += matrizOriginal[row][filas[row]];
        return total;
    }

    /**
     * Copia una matriz
     *
     * @return Copia de la matriz dada como parametro
     */
    private int[][] cloneMatrix(int[][] matrix) {
        int[][] tmp = new int[matrix.length][matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            tmp[row] = matrix[row].clone();
        }
        return tmp;
    }
}
