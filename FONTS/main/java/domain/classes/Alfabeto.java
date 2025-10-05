package domain.classes;

import java.util.ArrayList;

/**
 *  @author Nicolas Longueira
 */

public class Alfabeto {

    // ==========================================================
    //           ATRIBUTOS
    // ==========================================================

    /**
     *  ArrayList con los caracteres del alfabeto.
     */
    private String alfabeto;

    /**
     * ArrayList de los ids de los teclados asociados.
     */
    private ArrayList<Integer> idsTecladosAsociados;

    // ==========================================================
    //           CONSTRUCTOR
    // ==========================================================

    /**
     * Constructor de alfabeto.
     *
     * @param alfabeto conjunto de simbolos del alfabeto.
     */
    public Alfabeto(String alfabeto) {
        this.alfabeto = alfabeto;
        this.idsTecladosAsociados = new ArrayList<>();
    }

    // ==========================================================
    //           FUNCIONES
    // ==========================================================


    /**
     * Getter de los simbolos del alfabeto.
     *
     * @return los simbolos del Alfabeto.
     */
    public String getAlfabeto() {
        return this.alfabeto;
    }

    /**
     * Getter de los ids de los teclados asociados
     * @return idsTecladosAsociados
     */
    public ArrayList<Integer> getIdsTecladosAsociados() {
        return idsTecladosAsociados;
    }

    /**
     * Setter de los conjuntos de simbolos del alfabeto.
     *
     * @param alfabeto nuevo conjunto de simbolos del alfabeto.
     */
    public void setAlfabeto(String alfabeto) {
        this.alfabeto = alfabeto;
    }

    /**
     * Comprueba si el alfabeto tiene algun teclado asociado.
     * @return true: si el alfabeto está asociado.
     *         false: si el alfabeto no está asociado.
     */
    public Boolean hasTecladoAsociado() {
        return (!idsTecladosAsociados.isEmpty());
    }

    /**
     * Comprueba si un teclado con idTeclado tiene asociado este alfabeto.
     * @param idTeclado id del teclado que se quiere comprobar.
     * @return true: si el alfabeto está asociado al teclado idTeclado
     *         false: si el alfabeto no está asociado al teclado
     */
    public Boolean checkTecladoAsociado(Integer idTeclado) {
        return (idsTecladosAsociados.contains(idTeclado));
    }

    /**
     * Añade un teclado asociado al alfabeto.
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
     * Elimina un teclado asociado al alfabeto.
     * @param idTeclado id del teclado asociado.
     * @return true: si se ha eliminado correctamente.
     *         false: si no estaba asociado al alfabeto.
     */
    public Boolean deleteTecladoAsociado(Integer idTeclado) {
        if (!checkTecladoAsociado(idTeclado)) return false;
        idsTecladosAsociados.remove(idTeclado);
        return true;
    }

}
