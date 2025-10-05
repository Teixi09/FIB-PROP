package domain.classes;

import java.util.ArrayList;

/**
 *  @author Santi Cervera
 */

public class Texto {

    // ==========================================================
    //           ATRIBUTOS
    // ==========================================================

    /**
     *  ArrayList con los caracteres del texto.
     */
    private String texto;

    /**
     * ArrayList de los ids de los teclados asociados.
     */
    private ArrayList<Integer> idsTecladosAsociados;

    // ==========================================================
    //           CONSTRUCTOR
    // ==========================================================

    /**
     * Constructor de texto.
     * @param texto conjunto de simbolos del texto.
     */
    public Texto(String texto) {
        this.texto = texto;
        this.idsTecladosAsociados = new ArrayList<>();
    }

    // ==========================================================
    //           FUNCIONES
    // ==========================================================

    /**
     * Getter de los simbolos del texto.
     * @return los simbolos del Texto.
     */
    public String getTexto() {
        return this.texto;
    }

    /**
     * Getter de los ids de los teclados asociados
     * @return idsTecladosAsociados
     */
    public ArrayList<Integer> getIdsTecladosAsociados() {
        return idsTecladosAsociados;
    }

    /**
     * Setter de los conjuntos de simbolos del texto.
     * @param texto nuevo conjunto de simbolos del texto.
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Comprueba si el texto tiene algun teclado asociado.
     * @return true: si el texto está asociado.
     *         false: si el texto no está asociado.
     */
    public Boolean hasTecladoAsociado() {
        return (!idsTecladosAsociados.isEmpty());
    }

    /**
     * Comprueba si un teclado con idTeclado tiene asociado este texto.
     * @param idTeclado id del teclado que se quiere comprobar.
     * @return true: si el texto está asociado al teclado idTeclado
     *         false: si el texto no está asociado al teclado
     */
    public Boolean checkTecladoAsociado(Integer idTeclado) {
        return (idsTecladosAsociados.contains(idTeclado));
    }

    /**
     * Añade un teclado asociado al texto.
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
     * Elimina un teclado asociado al texto.
     * @param idTeclado id del teclado asociado.
     * @return true: si se ha eliminado correctamente.
     *         false: si no estaba asociado al texto.
     */
    public Boolean deleteTecladoAsociado(Integer idTeclado) {
        if (!checkTecladoAsociado(idTeclado)) return false;
        idsTecladosAsociados.remove(idTeclado);
        return true;
    }
}
