package domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Enric Teixidó
 */

public class CjtListaPalabras {
    // ==========================================================
    //           ATRIBUTOS
    // ==========================================================

    /**
     * Conjunto de listas de palabras.
     */
    private HashMap<Integer, ListaDePalabras> listasDePalabras;

    // ==========================================================
    //           CONSTRUCTOR
    // ==========================================================

    /**
     * Constructor de conjunto de listas de palabras vacio.
     */
    public CjtListaPalabras() { this.listasDePalabras = new HashMap<>(); }

    // ==========================================================
    //           FUNCIONES
    // ==========================================================

    /**
     * Añade una lista de palabras al conjunto.
     * @param id identificador del la lista de palabras.
     * @param listaPalabras lista a añadir.
     */
    public void crearListaDePalabras(Integer id, HashMap<String, Integer> listaPalabras) {
        listasDePalabras.put(id, new ListaDePalabras(listaPalabras));
    }

    /**
     * Edita una lista de palabras.
     * @param idLista id de la lista que se quiere modificar.
     * @param newLista lista modificada.
     */
    public void editarListaDePalabras(Integer idLista, HashMap<String, Integer> newLista) {
        listasDePalabras.get(idLista).setListaPalabras(newLista);
    }

    /**
     * Elimina una lista de palabras del conjunto
     * @param id identificador del la lista a eleminiar..
     */
    public void eliminarListaDePalabras(Integer id) {
        listasDePalabras.remove(id);
    }

    /**
     * Getter de una lista de palabras
     * @param id identificador de la lista de palabras que se desea.
     * @pre La lista de palabras con identificador = username + "#" + nombre existe
     * @return ListaDePalabras
     */
    public HashMap<String, Integer> getListaDePalabras(Integer id) {
        return listasDePalabras.get(id).getListaPalabras();
    }

    /**
     * Getter de los ids de los teclados asociados de una lista
     * @param idLista id del alfabeto
     * @return idsTecladosAsociados
     */
    public ArrayList<Integer> getIdsTecladosAsociados(Integer idLista) {
        return listasDePalabras.get(idLista).getIdsTecladosAsociados();
    }

    /**
     * Comprueba si una lista de palabras esta asociada a algun teclado
     * @param idLista id de la lista de palabras de la que se quiere comprobar.
     * @return true: si la lista de palabras está asociada
     *         false: si la lista de palabras no está asociada
     */
    public Boolean hasTecladoAsociado(Integer idLista) {
        return listasDePalabras.get(idLista).hasTecladoAsociado();
    }

    /**
     * Añade un teclado asociado a la lista de palabras.
     *
     * @param idLista   id de la lista a la que se asocia el teclado.
     * @param idTeclado id del teclado asociado.
     */
    public void addTecladoAsociado(Integer idLista, Integer idTeclado) {
        listasDePalabras.get(idLista).addTecladoAsociado(idTeclado);
    }

    /**
     * Elimina un teclado asociado a la lista de palabras.
     *
     * @param idLista   id de la lista de la que se quiere eliminar el teclado asociado.
     * @param idTeclado id del teclado asociado.
     */
    public void deleteTecladoAsociado(Integer idLista, Integer idTeclado) {
        if (idLista != -1) {
            listasDePalabras.get(idLista).deleteTecladoAsociado(idTeclado);
        }
    }

}