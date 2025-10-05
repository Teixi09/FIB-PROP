package domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *  @author Enric Teixidó
 */

public class ListaDePalabras {

    // ==========================================================
    //           ATRIBUTOS
    // ==========================================================

    /**
     *  HashMap con las palabras y sus freqüencias.
     */
    private HashMap<String, Integer> listaPalabras;

    /**
     * ArrayList de los ids de los teclados asociados.
     */
    private ArrayList<Integer> idsTecladosAsociados;

    // ==========================================================
    //           CONSTRUCTOR
    // ==========================================================

    /**
     * Constructor de ListaDePalabras.
     * @param listaPalabras hashmap de las palabras con sus freqüencias
     */
    public ListaDePalabras(HashMap<String, Integer> listaPalabras) {
        this.listaPalabras = listaPalabras;
        this.idsTecladosAsociados = new ArrayList<>();
    }

    // ==========================================================
    //           FUNCIONES
    // ==========================================================

    /**
     * Getter de la listaPalabras
     * @return listaPalabras
     */
    public HashMap<String, Integer> getListaPalabras() {
        return listaPalabras;
    }

    /**
     * Getter de los ids de los teclados asociados
     * @return idsTecladosAsociados
     */
    public ArrayList<Integer> getIdsTecladosAsociados() {
        return idsTecladosAsociados;
    }

    /**
     * Getter de la freqüencia de una palabra.
     * @param Palabra palabra de la que queremos saber la freqÜencia
     * @pre la ListaDePalabras contiene la palabra Palabra.
     * @return freqüencia de la palabra.
     */
    public Integer getFrec(String Palabra) {
        return this.listaPalabras.get(Palabra);
    }

    /**
     * Setter de la listaPalabras.
     * @param listaPalabras hashmap con las palabras y sus freqüencias.
     */
    public void setListaPalabras(HashMap<String, Integer> listaPalabras) {
        this.listaPalabras = listaPalabras;
    }

    /**
     * Comprueba si la lista de palabras tiene algun teclado asociado.
     * @return true: si la lista de palabras está asociada.
     *         false: si la lista de palabras no está asociada.
     */
    public Boolean hasTecladoAsociado() {
        return (!idsTecladosAsociados.isEmpty());
    }

    /**
     * Comprueba si un teclado con idTeclado tiene asociado esta lista de palabras.
     * @param idTeclado id del teclado que se quiere comprobar.
     * @return true: si la lista de palabras está asociada al teclado idTeclado
     *         false: si la lista no está asociada al teclado
     */
    public Boolean checkTecladoAsociado(Integer idTeclado) {
        return (idsTecladosAsociados.contains(idTeclado));
    }

    /**
     * Añade un teclado asociado a la lista de palabras.
     * @param idTeclado id del teclado asociado.
     * @return true: si se ha añadido correctamente.
     *         false: si ya estaba asociado.
     */
    public Boolean addTecladoAsociado(Integer idTeclado) {
        if (checkTecladoAsociado(idTeclado)) return false;
        idsTecladosAsociados.add(idTeclado);
        return true;
    }

    /**
     * Elimina un teclado asociado a la lista de palabras.
     * @param idTeclado id del teclado asociado.
     * @return true: si se ha eliminado correctamente.
     *         false: si no estaba asociado a la lista de palabras.
     */
    public Boolean deleteTecladoAsociado(Integer idTeclado) {
        if (!checkTecladoAsociado(idTeclado)) return false;
        idsTecladosAsociados.remove(idTeclado);
        return true;
    }
}
