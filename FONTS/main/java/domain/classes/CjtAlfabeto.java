package domain.classes;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *  @author Nicolas Longueira
 */

public class CjtAlfabeto {

    // ==========================================================
    //           ATRIBUTOS
    // ==========================================================

    /**
     *  Conjunto del alfabetos.
     */
    private HashMap<Integer, Alfabeto> alfabetos;

    // ==========================================================
    //           CONSTRUCTOR
    // ==========================================================

    /**
     * Constructor de conjunto de alfabetos vacio.
     */
    public CjtAlfabeto() {
        alfabetos = new HashMap<>();
    }

    // ==========================================================
    //           FUNCIONES
    // ==========================================================

    /**
     * Añade un alfabeto al conjunto de alfabetos.
     *
     * @param id identificador del alfabeto.
     * @param alfabeto conjunto de simbolos del alfabeto.
     */
    public void crearAlfabeto(Integer id ,String alfabeto) {
        alfabetos.put(id, new Alfabeto(alfabeto));
    }

    /**
     * Edita el alfabeto por uno nuevo.
     * @param idAlfabeto id del alfabeto que se quiere modificar.
     * @param newAlfabeto alfabeto modificado.
     */
    public void editarAlfabeto(Integer idAlfabeto, String newAlfabeto) {
        alfabetos.get(idAlfabeto).setAlfabeto(newAlfabeto);
    }

    /**
     * Elimina un alfabeto del conjunto de alfabetos.
     *
     * @param id identificador del alfabeto a eleminiar.
     * */
    public void eliminarAlfabeto(Integer id) {
        alfabetos.remove(id);
    }

    /**
     * Getter del alfabeto.
     * @param id id del afabeto
     * @return listaPalabras
     */
    public String getAlfabeto(Integer id) {
        return alfabetos.get(id).getAlfabeto();
    }

    /**
     * Getter de los ids de los teclados asociados de un alfabeto
     * @param idAlfabeto id del alfabeto
     * @return idsTecladosAsociados
     */
    public ArrayList<Integer> getIdsTecladosAsociados(Integer idAlfabeto) {
        return alfabetos.get(idAlfabeto).getIdsTecladosAsociados();
    }

    /**
     * Comprueba si un alfabeto esta asociado a algun teclado
     * @param idAlfabeto id del alfabeto del que se quiere comprobar.
     * @return true: si el alfabeto está asociado
     *         false: si el alfabeto no está asociado
     */
    public Boolean hasTecladoAsociado(Integer idAlfabeto) {
        return alfabetos.get(idAlfabeto).hasTecladoAsociado();
    }

    /**
     * Añade un teclado asociado al alfabeto.
     *
     * @param idAlfabeto id del alfabeto al que se quiere asociar el teclado.
     * @param idTeclado  id del teclado asociado.
     */
    public void addTecladoAsociado(Integer idAlfabeto, Integer idTeclado) {
        alfabetos.get(idAlfabeto).addTecladoAsociado(idTeclado);
    }

    /**
     * Elimina un teclado asociado al alfabeto.
     *
     * @param idAlfabeto id del alfabeto del que se quiere quitar el teclado asociado.
     * @param idTeclado  id del teclado asociado.
     */
    public void deleteTecladoAsociado(Integer idAlfabeto, Integer idTeclado) {
        if (idAlfabeto != -1) {
            alfabetos.get(idAlfabeto).deleteTecladoAsociado(idTeclado);
        }
    }

}
