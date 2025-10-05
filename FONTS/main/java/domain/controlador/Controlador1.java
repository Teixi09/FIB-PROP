package domain.controlador;
import domain.classes.CjtAlfabeto;
import domain.classes.CjtTeclado;
import domain.classes.CjtListaPalabras;
import domain.classes.CjtTextos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *  @author Nicolas Longueira
 *  @author Enric Teixido
 */

public class Controlador1 {

    // ==========================================================
    //           ATRIBUTOS
    // ==========================================================

    /**
     *  Conjunto de alfabetos.
     */
    static CjtAlfabeto alfabetos;

    /**
     *  Conjunto de teclados.
     */
    static CjtTeclado teclados;

    /**
     *  Conjunto de Listas de palabras
     */
    static CjtListaPalabras listasDePalabras;

    /**
     *  Conjunto de Listas de palabras
     */
    static CjtTextos textos;

    // ==========================================================
    //           CONSTRUCTOR
    // ==========================================================

    /**
     * Constructor del controlador1.
     */
    public Controlador1() {
        alfabetos = new CjtAlfabeto();
        teclados = new CjtTeclado();
        listasDePalabras = new CjtListaPalabras();
        textos = new CjtTextos();
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
    public void crearAlfabeto(Integer id, String alfabeto) {
        alfabetos.crearAlfabeto(id, alfabeto);
    }

    /**
     * Añade un teclado al conjunto de teclados.
     *
     * @param id identificador del teclado.
     * @param idAlfabeto identificador del alfabeto asociado.
     * @param idTexto identificador del texto asociado. (-1 si no tiene)
     * @param idLista identificador de la lista asociada. (-1 si no tiene)
     * @param layout distribucion de teclas correspondiente del teclado.
     */
    public void crearTeclado(Integer id, Integer idAlfabeto, Integer idTexto, Integer idLista, char[][] layout) {
            teclados.crearTeclado(id, idAlfabeto, idTexto, idLista, layout);
            alfabetos.addTecladoAsociado(idAlfabeto, id);
            if (idTexto != -1) textos.addTecladoAsociado(idTexto, id);
            if (idLista != -1) listasDePalabras.addTecladoAsociado(idLista, id);
    }

    /**
     * Añade una lista de palabras al conjunto.
     *
     * @param id identificador de la lista de palabras
     * @param listaPalabras palabras con sus respectivas freqüencias.
     */
    public void crearListaDePalabras(Integer id, HashMap<String, Integer> listaPalabras) {
        listasDePalabras.crearListaDePalabras(id, listaPalabras);
    }

    /**
     * Añade una texto al conjunto.
     *
     * @param id identificador del texto
     * @param texto  texto.
     */
    public void crearTexto(Integer id, String texto) {
        textos.crearTexto(id, texto);
    }

    /**
     * Edita un alfabeto.
     * @param idAlfabeto id del alfabeto.
     * @param newAlfabeto alfabeto modificado.
     * @return true: si se ha podido editar correctamente.
     *         false: en caso de que el alfabeto este asociado a un teclado y no se pueda editar.
     */
    public Boolean editarAlfabeto(Integer idAlfabeto, String newAlfabeto) {
        if (alfabetos.hasTecladoAsociado(idAlfabeto)) return false;
        alfabetos.editarAlfabeto(idAlfabeto, newAlfabeto);
        return true;
    }

    /**
     * Edita un texto.
     * @param idTexto id del texto.
     * @param newTexto texto modificado.
     * @return true: si se ha podido editar correctamente.
     *         false: en caso de que el texto este asociado a un teclado y no se pueda editar.
     */
    public Boolean editarTexto(Integer idTexto, String newTexto) {
        if (textos.hasTecladoAsociado(idTexto)) return false;
        textos.editarTexto(idTexto, newTexto);
        return true;
    }

    /**
     * Edita una lista de palabras.
     * @param idLista id de la lista.
     * @param newLista lista modificada.
     * @return true: si se ha podido editar correctamente.
     *         false: en caso de que la lista este asociada a un teclado y no se pueda editar.
     */
    public Boolean editarListaPalabras(Integer idLista, HashMap<String, Integer> newLista) {
        if (listasDePalabras.hasTecladoAsociado(idLista)) return false;
        listasDePalabras.editarListaDePalabras(idLista, newLista);
        return true;
    }

    /**
     * Elimina un teclado del conjunto de teclados.
     * @param id identificador del teclado.
     */
    public void eliminarTeclado(Integer id) {
        // eliminamos la asociacion de este teclado con su alfabeto.
        Integer idAlfabeto = teclados.getIdAlfabeto(id);
        alfabetos.deleteTecladoAsociado(idAlfabeto, id);
        // eliminamos la asociacion de la lista o texto al teclado.
        Integer idTexto = teclados.getIdTexto(id);
        if (!textos.deleteTecladoAsociado(idTexto, id)) {
            listasDePalabras.deleteTecladoAsociado(teclados.getIdLista(id), id);
        }
        teclados.eliminarTeclado(id);
    }

    /**
     * Elimina una lista de palabras del conjunto.
     *
     * @param id identificador del la lista a eleminiar..
     * @return true: si el alfabeto se ha eliminado correctamente.
     *         false: si el alfabeto contenia una asociacion de teclado.
     * */
    public Boolean eliminarAlfabeto(Integer id) {
        if (alfabetos.hasTecladoAsociado(id)) return false;
        alfabetos.eliminarAlfabeto(id);
        return true;
    }

    /**
     * Elimina una lista de palabras del conjunto
     *
     * @param id identificador de la lista de palabras que se desea.
     * @return true: si la lista se ha eliminado correctamente.
     *         false: si la lista contenia una asociacion de teclado.
     */
    public Boolean eliminarListaDePalabras(Integer id) {
        if (listasDePalabras.hasTecladoAsociado(id)) return false;
        listasDePalabras.eliminarListaDePalabras(id);
        return true;
    }

    /**
     * Elimina un texto del conjunto
     *
     * @param id identificador del texto.
     * @return true: si el alfabeto se ha eliminado correctamente.
     *         false: si el alfabeto contenia una asociacion de teclado.
     */
    public Boolean eliminarTexto(Integer id) {
        if (textos.hasTecladoAsociado(id)) return false;
        textos.eliminarTexto(id);
        return true;
    }

    /**
     * Getter del texto con id id
     * @param id id del texto
     * @return texto con id id
     */
    public String getTexto(Integer id) {
        return textos.getTexto(id);
    }

    /**
     * Getter del alfabeto con id id
     * @param id id del alfabeto
     * @return alfabeto con id id
     */
    public String getAlfabeto(Integer id) {
        return alfabetos.getAlfabeto(id);
    }

    /**
     * Getter de la lista con id id
     * @param id id de la lista
     * @return lista con id id
     */
    public HashMap<String, Integer> getListaPalabras(Integer id) {
        return listasDePalabras.getListaDePalabras(id);
    }

    public char[][] getTeclado(Integer idTeclado) {
        return teclados.getLayoutTeclado(idTeclado);
    }

    /**
     * Getter de los ids de los teclados asociados de un alfabeto
     * @param idAlfabeto id del alfabeto
     * @return idsTecladosAsociados
     */
    public ArrayList<Integer> getTecladosAsociadosAlfabeto(Integer idAlfabeto) {
        return alfabetos.getIdsTecladosAsociados(idAlfabeto);
    }

    /**
     * Getter de los ids de los teclados asociados de un texto
     * @param idTexto id del texto
     * @return idsTecladosAsociados
     */
    public ArrayList<Integer> getTecladosAsociadosTexto(Integer idTexto) {
        return textos.getIdsTecladosAsociados(idTexto);
    }

    /**
     * Getter de los ids de los teclados asociados de una lista
     * @param idLista id de la lista
     * @return idsTecladosAsociados
     */
    public ArrayList<Integer> getTecladosAsociadosLista(Integer idLista) {
        return listasDePalabras.getIdsTecladosAsociados(idLista);
    }

    /**
     * Adder de los ids de los teclados asociados de un alfabeto
     * @param idAlfabeto id del alfabeto
     * @param idsTeclados id de los teclados asociados
     */
    public void addTecladosAsociadosAlfabeto(int idAlfabeto, ArrayList<Integer> idsTeclados) {
        for (Integer i : idsTeclados)
            alfabetos.addTecladoAsociado(idAlfabeto, i);
    }
    /**
     * Adder de los ids de los teclados asociados de un texto
     * @param idTexto id del alfabeto
     * @param idsTeclados id de los teclados asociados
     */
    public void addTecladosAsociadosTexto(int idTexto, ArrayList<Integer> idsTeclados) {
        for (Integer i : idsTeclados)
            textos.addTecladoAsociado(idTexto, i);
    }

    /**
     * Adder de los ids de los teclados asociados de una lista
     * @param idListas id del alfabeto
     * @param idsTeclados id de los teclados asociados
     */
    public void addTecladosAsociadosLista(int idListas, ArrayList<Integer> idsTeclados) {
        for (Integer i : idsTeclados)
            listasDePalabras.addTecladoAsociado(idListas, i);
    }

    /**
     * Getter del id del alfabeto asociado al teclado.
     * @param idTeclado id del teclado a consultar.
     * @return idAlfabeto;
     */
    public Integer getIdAlfabeto(Integer idTeclado) {
        return teclados.getIdAlfabeto(idTeclado);
    }

    /**
     * Getter del id del texto asociado al teclado
     * @param idTeclado id del teclado a consultar.
     * @return idTexto;
     */
    public Integer getIdTexto(Integer idTeclado) {
        return teclados.getIdTexto(idTeclado);
    }

    /**
     * Getter del id de la lista asociada al teclado.
     * @param idTeclado id del teclado a consultar.
     * @return idLista;
     */
    public Integer getIdLista(Integer idTeclado) {
        return teclados.getIdLista(idTeclado);
    }
}
